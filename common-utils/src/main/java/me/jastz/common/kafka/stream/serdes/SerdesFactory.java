package me.jastz.common.kafka.stream.serdes;

import me.jastz.common.kafka.serialization.GenericDeserializer;
import me.jastz.common.kafka.serialization.GenericSerializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

/**
 * @author zhiwen
 */
public class SerdesFactory {
    private SerdesFactory() {
    }

    /**
     * 根据value的类型获取序列化、反序列化解析器
     *
     * @param pojoClass
     * @param <T>
     * @return
     */
    public static <T> Serde<T> serdesFrom(Class<T> pojoClass) {
        return Serdes.serdeFrom(new GenericSerializer<>(pojoClass), new GenericDeserializer<>(pojoClass));
    }
}
