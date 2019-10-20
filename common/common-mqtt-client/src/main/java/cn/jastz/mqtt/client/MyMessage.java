package cn.jastz.mqtt.client;

public class MyMessage<T> {
    private String topic;
    private QosEnums qosEnums;
    private T msg;
    private String clientId;

    public MyMessage(String topic, T msg) {
        this(topic,msg,QosEnums.AT_LEAST_ONCE);
    }

    public MyMessage( String topic, T msg, QosEnums qosEnums) {
        this.topic = topic;
        this.qosEnums = qosEnums;
        this.msg = msg;
    }

    public MyMessage(T msg) {
        this.msg = msg;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public QosEnums getQosEnums() {
        return qosEnums;
    }

    public void setQosEnums(QosEnums qosEnums) {
        this.qosEnums = qosEnums;
    }

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
