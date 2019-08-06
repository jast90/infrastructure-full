package me.jastz.common.base.object;


import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

/**
 * Created by zhiwen on 2017/3/29.
 */
public class ObjectUtil {

    public static <T> Map<String, OldNewValue> differentValueFields(T oldObject, T newObject) {
        Map<String, OldNewValue> result = Maps.newHashMap();

        Class clazz = oldObject.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object oldFiledValue = field.get(oldObject);
                Object newFiledValue = field.get(newObject);
                if (!Objects.deepEquals(oldFiledValue, newFiledValue)) {
                    result.put(field.getName(), new OldNewValue(oldFiledValue, newFiledValue));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
