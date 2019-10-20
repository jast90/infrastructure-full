package cn.jastz.mqtt.client.factory;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * @author zhangzhiwen on 2019/10/20
 */
public class DefaultMqttClientFactory implements MqttClientFactory {
    private MqttConfig mqttConfig;

    public DefaultMqttClientFactory() {
        this(new DefaultMqttConfig());
    }


    public DefaultMqttClientFactory(MqttConfig mqttConfig) {
        this.mqttConfig = mqttConfig;
    }

    @Override
    public MqttClient createMqttClient() {
        MqttClient mqttClient = null;
        try {
            mqttClient = new MqttClient(mqttConfig.getBrokerURI(), mqttConfig.getClientId(),
                    mqttConfig.getMqttClientPersistence());
            mqttClient.connect(mqttConfig.getMqttConnectOptions());
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return mqttClient;
    }
}