package cn.jastz.mq.entity;

/**
 * @author zhiwen
 */
public class Message<T> {
    private String topic;
    private T message;
    private String key;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
