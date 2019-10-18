package cn.jastz.mqtt.client;

import com.google.common.collect.Maps;
import me.jastz.common.json.JsonUtil;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class MqttReceiverUtil {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static MqttReceiverUtil instance;
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

    public MqttReceiverUtil(String broker, String clientId) {
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
                    MyMessage myMessage = JsonUtil.byteArrayToObject(message.getPayload(),MyMessage.class);
                    logger.debug("Receive message:{}",JsonUtil.objectToJson(myMessage));
                    mqttClient.publish(myMessage.getClientId(),new MqttMessage("ok".getBytes()));
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

    public static MqttReceiverUtil getInstance(String broker, String clientId) {
        if (instance == null) {
            instance = new MqttReceiverUtil(broker, clientId);
        }
        return instance;
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
