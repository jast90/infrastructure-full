package cn.jastz.mqtt.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Maps;
import me.jastz.common.json.JsonUtil;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

public class MqttSenderUtil {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static MqttSenderUtil instance;
    private MqttClient mqttClient;
    private String broker;
    private String clientId;
    private static Map<String, Result> resultMap = Maps.newConcurrentMap();//TODO 如何获取确认消费消息

    private class Result {
        private String topic;
        private CountDownLatch countDownLatch;
        private MqttMessage mqttMessage;

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

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

    public MqttSenderUtil(String broker, String clientId) {
        this.broker = broker;
        this.clientId = clientId;
        init();
    }

    private void init() {
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            mqttClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            mqttClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {

                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    /*logger.debug("Receive message:{}",
                            JsonUtil.objectToJson(JsonUtil.byteArrayToObject(message.getPayload(),Result.class)));*/
                    if (Objects.equals(topic, getClientId())) {
                        Result result = resultMap.get(getClientId());
                        result.setMqttMessage(message);
                        result.getCountDownLatch().countDown();
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            });
            mqttClient.connect(connOpts);
            logger.debug("Connect to broker:{} success.", broker);
            mqttClient.subscribe(String.format("%s", getClientId()));
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public static MqttSenderUtil getInstance(String broker, String clientId) {
        if (instance == null) {
            instance = new MqttSenderUtil(broker, clientId);
        }
        return instance;
    }

    public <R> Future<R> send(String topic, MyMessage message, Class<R> rClass) {
        return this.send(topic, message, 1, rClass);
    }

    public <R> Future<R> send(String topic, MyMessage message, int qos, Class<R> rClass) {
        CompletableFuture completableFuture = new CompletableFuture();
        try {
            message.setClientId(getClientId());
            MqttMessage mqttMessage = new MqttMessage(JsonUtil.objectToByteArray(message));
            mqttMessage.setQos(qos);
            Result result = new Result();
            result.setTopic(topic);
            result.setCountDownLatch(new CountDownLatch(1));
            resultMap.put(getClientId(), result);
            mqttClient.publish(topic, mqttMessage);
            //TODO 获取消费确认消息：那个client发送的，消费方就发送给相应的client topic
            result.getCountDownLatch().await();/*.await(1, TimeUnit.MINUTES)*/;
            completableFuture.complete(JsonUtil.byteArrayToObject(result.getMqttMessage().getPayload(), rClass));
        } catch (MqttException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            resultMap.remove(getClientId());
        }
        return completableFuture;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
