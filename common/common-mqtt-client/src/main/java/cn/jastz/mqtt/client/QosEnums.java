package cn.jastz.mqtt.client;

/**
 * @author zhangzhiwen on 2019/10/20
 **/
public enum QosEnums {
    /**
     * 最多一次
     */
    AT_MOST_ONCE(0),
    /**
     * 至少一次
     */
    AT_LEAST_ONCE(1),
    /**
     * 仅一次
     */
    EXACTLY_ONCE(2);
    private int qos;

    QosEnums(int qos) {
        this.qos = qos;
    }

    public int getQos() {
        return qos;
    }
}
