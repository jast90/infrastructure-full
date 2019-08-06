package me.jastz.common.chinese;

import com.luhuiguo.chinese.ChineseUtils;
import me.jastz.common.java.PropertiesUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author zhiwen
 */
public class ChineseUtil {


    public static void simple2Traditional(Properties simpleProperties, String traditionalFileName) {
        Properties traditionalProperties = new Properties();
        simpleProperties.keySet().forEach(name -> {
            traditionalProperties.setProperty((String) name, ChineseUtils.toTraditional(simpleProperties.getProperty((String) name)));
        });
        PropertiesUtil.propertiesToFile(traditionalProperties, traditionalFileName);
    }

    public static void simple2Traditional(String simplePropertiesFileName, String traditionalFileName) throws IOException {
        Properties simpleProperties = new Properties();
        simpleProperties.load(new FileInputStream(simplePropertiesFileName));
        simple2Traditional(simpleProperties, traditionalFileName);
    }
}
