package cn.jastz.mqtt.client;

import me.jastz.common.json.JsonUtil;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

public class Client {

    private final static Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args)  {
        String topic = "MQTT Examples";
        String content  = "Message from MqttPublishSample";
        int qos = 2;
        String broker = "tcp://localhost:1883";
        String clientId  = "JavaSample";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            MqttClient mqttClient = new MqttClient(broker,clientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            mqttClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {

                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    logger.debug("Receive message:{}",
                            JsonUtil.objectToJson(new String(message.getPayload(), Charset.forName("UTF-8"))));
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            });

            //连接
            logger.debug("Connect to broker:{}",broker);
            mqttClient.connect(connOpts);
            logger.debug("Connected");

            //订阅消息
            mqttClient.subscribe(topic);

            //发送消息
            logger.debug("Send message:{}",content);
            MqttMessage mqttMessage = new MqttMessage(content.getBytes());
            mqttMessage.setQos(qos);
            mqttClient.publish(topic,mqttMessage);
            logger.debug("Send message success");

           Runtime.getRuntime().addShutdownHook(new Thread(()-> {
               try {
                   logger.debug("unsubscribe topic:{}",topic);
                   mqttClient.unsubscribe(topic);
                   logger.debug("disconnect clientId:{}",clientId);
                   mqttClient.disconnect();
               } catch (MqttException e) {
                   e.printStackTrace();
               }
           }));
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
