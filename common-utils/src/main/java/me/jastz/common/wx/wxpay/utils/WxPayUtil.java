package me.jastz.common.wx.wxpay.utils;

import org.apache.commons.codec.digest.Md5Crypt;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/**
 * @author zhiwen
 */
public class WxPayUtil {


    public static String generateNonceStr() {
        String uuid = UUID.randomUUID().toString();
        String nonceStr = uuid.replace("-", "").substring(0, 32);
        return nonceStr;
    }

    /**
     * 生成sign
     *
     * @param values
     * @param payKey
     * @return
     */
    public static String generateMD5Sign(Map<String, String> values, String payKey) {
        values = new TreeMap<>(values);
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : values.keySet()) {
            if ("sign".equals(key) || values.get(key) == null || "".equals(values.get(key))) {
                continue;
            }
            stringBuilder.append(key).append("=").append(values.get(key)).append("&");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        stringBuilder.append("&key=" + payKey);
        String sign = Md5Crypt.md5Crypt(stringBuilder.toString().getBytes()).toUpperCase();
        System.out.println(String.format("%s md5 is:%s", stringBuilder.toString(), sign));
        return sign;
    }

    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
        map.put("ab", "ab");
        map.put("aa", "aa");
        map.put("ac", "ac");
        map.put("a12", "ac");
        System.out.println(generateMD5Sign(map, "hello"));
    }
}
