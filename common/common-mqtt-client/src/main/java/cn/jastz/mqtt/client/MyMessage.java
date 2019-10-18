package cn.jastz.mqtt.client;

public class MyMessage<T> {
    private String clientId;
    private T msg;

    public MyMessage(T msg) {
        this.msg = msg;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }
}
