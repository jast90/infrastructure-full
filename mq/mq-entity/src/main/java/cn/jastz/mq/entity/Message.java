package cn.jastz.mq.entity;

/**
 * @author zhiwen
 */
public class Message<T> {
    private String topic;
    private T message;

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
}
