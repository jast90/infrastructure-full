package cn.jastz.mqtt.client.factory;

import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

public interface MqttConfig {

     String getBrokerURI();

     String getClientId();

     MqttConnectOptions getMqttConnectOptions() ;

    MqttClientPersistence getMqttClientPersistence();
}
