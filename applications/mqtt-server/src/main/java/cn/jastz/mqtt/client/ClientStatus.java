package cn.jastz.mqtt.client;

import java.io.Serializable;

public class ClientStatus implements Serializable {
    private String clientId;
    private int status;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
