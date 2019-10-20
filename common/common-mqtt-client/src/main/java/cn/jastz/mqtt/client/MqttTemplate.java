package cn.jastz.mqtt.client;

import cn.jastz.mqtt.client.factory.DefaultMqttClientFactory;
import cn.jastz.mqtt.client.factory.MqttClientFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Maps;
import me.jastz.common.json.JsonUtil;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SettableListenableFuture;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangzhiwen on 2019/10/20
 **/
public class MqttTemplate {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private MqttClientFactory mqttClientFactory;

    private static Map<String, Result> clientIdResultMap = Maps.newConcurrentMap();//TODO 需不需要支持分布式系统

    public MqttTemplate() {
        this(new DefaultMqttClientFactory());
    }

    public MqttTemplate(MqttClientFactory mqttClientFactory) {
        this.mqttClientFactory = mqttClientFactory;
    }

    public <R> ListenableFuture<R> send(MyMessage myMessage, Class<R> rClass, long timeout, TimeUnit timeUnit) {
        ListenableFuture<R> listenableFuture = new SettableListenableFuture();
        MqttClient mqttClient = null;
        try {
            mqttClient = mqttClientFactory.createMqttClient();
            if (mqttClient==null || mqttClient.isConnected() == false) {
                return null;
            }
            subscribe(mqttClient);
            doSendMsg(mqttClient, myMessage);
            Result result = clientIdResultMap.get(mqttClient.getClientId());
            result.countDownLatch.await(timeout,timeUnit);
            MqttMessage responseMsg;
            if ((responseMsg = result.mqttMessage) != null) {
                R r = JsonUtil.byteArrayToObject(responseMsg.getPayload(), rClass);
                ((SettableListenableFuture<R>) listenableFuture).set(r);
            }
        } catch (MqttException e) {
            logger.error("Mqtt client send message error:{} {}", e.getCause(), e);
        } catch (InterruptedException e) {
            logger.error("Get response message interrupter :{} {}", e.getCause(), e);
        } catch (IOException e) {
            logger.error("Object json serialize error:{} {}", e.getCause(), e);
        } finally {
            this.close(mqttClient);
        }
        return listenableFuture;
    }

    private MqttMessage getMqttMessage(MyMessage myMessage) {
        MqttMessage mqttMessage = null;
        try {
            mqttMessage = new MqttMessage(JsonUtil.objectToByteArray(myMessage));
            mqttMessage.setQos(myMessage.getQosEnums().getQos());
        } catch (JsonProcessingException e) {
            logger.error("Message to byte array error:{},{}",e.getMessage(),e);
        }
        return mqttMessage;
    }

    /**
     * 获取确认消息
     *
     * @param mqttClient
     */
    private void subscribe(MqttClient mqttClient) {
        try {
            mqttClient.subscribe(mqttClient.getClientId(), (topic, message) -> {
                logger.debug("topic:{},message:{}",topic,JsonUtil.objectToJson(message));
                if (Objects.equals(topic, mqttClient.getClientId())) {
                    Result result = clientIdResultMap.get(mqttClient.getClientId());
                    if (result != null) {
                        result.setMqttMessage(message);
                        result.getCountDownLatch().countDown();
                    }
                }
            });
        } catch (MqttException e) {
            logger.debug("Subscribe error:{} {}",e.getMessage(),e);
        }
    }

    /**
     * 发送消息
     *
     * @param mqttClient
     * @param myMessage
     * @throws MqttException
     */
    private void doSendMsg(MqttClient mqttClient, MyMessage myMessage) throws MqttException {
        myMessage.setClientId(mqttClient.getClientId());
        mqttClient.publish(myMessage.getTopic(), getMqttMessage(myMessage));
        Result result = new Result();
        result.setCountDownLatch(new CountDownLatch(1));
        clientIdResultMap.put(mqttClient.getClientId(), result);
    }

    /**
     * 关闭mqtt 客户端连接及释放响应消息内存
     * @param mqttClient
     */
    private void close(MqttClient mqttClient) {
        try {
            if (mqttClient != null) {
                //断开连接
                mqttClient.disconnect();
                logger.debug("Mqtt client disconnected.");
                //释放返回结果内存
                clientIdResultMap.remove(mqttClient.getClientId());
            }
        } catch (MqttException e) {
            logger.error("Mqtt client disconnect error:{},{}",e.getMessage(),e);
        }
    }

    private class Result {
        private CountDownLatch countDownLatch;
        private MqttMessage mqttMessage;

        public CountDownLatch getCountDownLatch() {
            return countDownLatch;
        }

        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public MqttMessage getMqttMessage() {
            return mqttMessage;
        }

        public void setMqttMessage(MqttMessage mqttMessage) {
            this.mqttMessage = mqttMessage;
        }
    }
}
