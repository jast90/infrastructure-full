package me.jastz.file;

import me.jastz.common.file.FileUtils;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * @author zhiwen
 */
public class FileUtilsTest {

    @Test
    public void test() {
        FileUtils.writeJsonToFile("{\"topic_id\":1761,\"offset\":40,\"hash_id\":\"9cef480724bc04772e8ee646e2e76d8f\"}", "params.json", Paths.get("E:", "json", "test"));
    }
}
