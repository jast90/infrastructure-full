package me.jastz.json;

import me.jastz.common.json.JsonUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zhiwen
 */
public class Object2ByteArray {

    @Test
    public void object2ByteArray2Object() throws IOException {
        User user = new User("jast", 23);
        byte[] bytes = JsonUtil.objectToByteArray(user);
        User user1 = JsonUtil.byteArrayToObject(bytes, User.class);
        System.out.println(JsonUtil.objectToPrettyJson(user));
        System.out.println(user);
        System.out.println(JsonUtil.objectToPrettyJson(user1));
        System.out.println(user1);
    }
}
