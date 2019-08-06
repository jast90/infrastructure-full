package me.jastz.common.kafka;

import me.jastz.common.kafka.serialization.GenericDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @author zhiwen
 */
public class KafkaUtil {

    private static final Logger logger = LoggerFactory.getLogger("KafkaUtil");

    public static <K, V> void consumer(Properties properties, Class<V> type, String... topics) {
        properties.put("bootstrap.servers", "localhost:9092");
//        properties.put("group.id", "test");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", GenericDeserializer.class.getName());
        properties.put("value.deserializer.type", type.getName());
        KafkaConsumer<K, V> consumer = new KafkaConsumer<>(properties);
        Thread mainTread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.debug("stop consumer");
            consumer.wakeup();
            try {
                mainTread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        consumer.subscribe(Arrays.asList(topics));
        while (true) {
            ConsumerRecords<K, V> consumerRecords = consumer.poll(10000);
            if (consumerRecords.isEmpty()) {
                System.out.println("收到的消息为空");
            }
            for (ConsumerRecord consumerRecord : consumerRecords) {
                logger.info("消费消息：topic:{} ,partition: {} ,offset:{} ,key:{} ,value:{}", consumerRecord.topic()
                        , consumerRecord.partition(), consumerRecord.offset(), consumerRecord.key(), consumerRecord.value());
            }
            consumer.commitSync();
        }
    }

    public static <K, V> void producer(Properties properties, String topic, K k, V v) {
        if (properties.contains("bootstrap.servers") == false) {
            properties.put("bootstrap.servers", "localhost:9092");
        }
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "me.jastz.common.kafka.serialization.GenericSerializer");
        properties.put("value.serializer.type", v.getClass().getName());
        Producer<K, V> producer = new KafkaProducer<>(properties);
        ProducerRecord producerRecord = new ProducerRecord<>(topic, k, v);
        Future<RecordMetadata> future = producer.send(producerRecord);
        producer.close();
        if (future.isDone()) {
            System.out.printf("消息%s发送成功", producerRecord);
        } else {
            System.out.println("消息发送失败");
        }

    }

}
