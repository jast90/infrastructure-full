package me.jastz.common.chinese;

import com.luhuiguo.chinese.ChineseUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zhiwen
 */
public class ChineseUtilTest {
    @Test
    public void test() {
        try {
//            ChineseUtil.simple2Traditional("E:\\mbss\\mbss-wxa\\src\\main\\resources\\i18n/messages_failure.properties", "E:\\mbss\\mbss-wxa\\src\\main\\resources\\i18n/messages_failure_zh_TW.properties");
            ChineseUtil.simple2Traditional("E:\\mbss\\mbss-device\\device-server\\src\\main\\resources\\i18n\\messages_failure.properties", "E:\\mbss\\mbss-device\\device-server\\src\\main\\resources\\i18n\\messages_failure.properties_zh_HK.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        System.out.println(ChineseUtils.toTraditional("项"));
    }
}
