package me.jastz.kafka;

import me.jastz.common.kafka.KafkaUtil;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Properties;

/**
 * @author zhiwen
 */
@Ignore
public class KafkaUtilTest {

    @Test
    public void producer() {
        Properties properties = new Properties();
        KafkaUtil.producer(properties, "youbaoStorePayment", "key9", "value9");
    }

    @Test
    public void consumer() {
        Properties properties = new Properties();
        KafkaUtil.<String, String>consumer(properties, String.class, "hello");
    }

    @Test
    public void producerObject() {
        User user = new User("jastzzz", 28);
        KafkaUtil.producer(new Properties(), "newUsers", user.getName(), user);
    }

    @Test
    public void consumerObject() {
        Properties properties = new Properties();
        KafkaUtil.<String, User>consumer(properties, User.class, "newUsers");
    }
}
