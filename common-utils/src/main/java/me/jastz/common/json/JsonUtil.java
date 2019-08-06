package me.jastz.common.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author zhiwen
 */
public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {
    }

    /**
     * 将json转成对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String json, Class<T> clazz) {
        T t = null;
        try {
            t = mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 对象转json
     *
     * @param object
     * @return
     */
    public static String objectToJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对象转json(优美的)
     *
     * @param object
     * @return
     */
    public static String objectToPrettyJson(Object object) {
        try {
            // 无法深度解析对象（并非无法深度解析而是jackson反序列化时是根据无参构造方法来方序列化的
            // ，如果对象属性在定义的时候赋了初值，默认是在无参构造方法中进行初始化的）
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] objectToByteArray(Object object) throws JsonProcessingException {
        return mapper.writeValueAsBytes(object);
    }

    public static <T> T byteArrayToObject(byte[] bytes, Class<T> tClass) throws IOException {
        return mapper.readValue(bytes, tClass);
    }
}
