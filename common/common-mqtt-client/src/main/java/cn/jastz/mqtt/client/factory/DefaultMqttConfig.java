package cn.jastz.mqtt.client.factory;

import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.UUID;

public class DefaultMqttConfig implements MqttConfig{
    private String brokerURI;
    private String clientId;
    private MqttConnectOptions mqttConnectOptions;
    private MqttClientPersistence mqttClientPersistence;

    public DefaultMqttConfig() {
        this.brokerURI = "tcp://localhost:1883";
        this.clientId = UUID.randomUUID().toString().replace("-","");
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        this.mqttConnectOptions = connOpts;
        this.mqttClientPersistence = new MemoryPersistence();
    }

    public DefaultMqttConfig(String brokerURI, String clientId, MqttConnectOptions mqttConnectOptions, MqttClientPersistence mqttClientPersistence) {
        this.brokerURI = brokerURI;
        this.clientId = clientId;
        this.mqttConnectOptions = mqttConnectOptions;
        this.mqttClientPersistence = mqttClientPersistence;
    }

    @Override
    public String getBrokerURI() {
        return brokerURI;
    }

    public void setBrokerURI(String brokerURI) {
        this.brokerURI = brokerURI;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public MqttConnectOptions getMqttConnectOptions() {
        return mqttConnectOptions;
    }

    public void setMqttConnectOptions(MqttConnectOptions mqttConnectOptions) {
        this.mqttConnectOptions = mqttConnectOptions;
    }

    @Override
    public MqttClientPersistence getMqttClientPersistence() {
        return mqttClientPersistence;
    }

    public void setMqttClientPersistence(MqttClientPersistence mqttClientPersistence) {
        this.mqttClientPersistence = mqttClientPersistence;
    }
}
