package cn.jastz.mqtt.client;

public enum  ClientStatusEnums {
    ONLINE(1),OFFLINE(0);

    private int code;

    ClientStatusEnums(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
