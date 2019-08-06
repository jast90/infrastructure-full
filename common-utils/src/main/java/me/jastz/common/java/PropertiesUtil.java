package me.jastz.common.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author zhiwen
 */
public class PropertiesUtil {
    private PropertiesUtil() {
    }

    public static void propertiesToFile(Properties properties, String fileName) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            properties.store(fileOutputStream, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
