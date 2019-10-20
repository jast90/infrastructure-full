package cn.jastz.mqtt.client.factory;

import org.eclipse.paho.client.mqttv3.MqttClient;

public interface MqttClientFactory {
    /**
     *
     * @return
     */
    MqttClient createMqttClient();
}
