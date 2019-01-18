package cn.jastz.mq.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author zhiwen
 */
@Component
public class MQConsumer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = "hello")
    public void listen(Object object) {
        logger.debug("Received: " + object);
    }

}
