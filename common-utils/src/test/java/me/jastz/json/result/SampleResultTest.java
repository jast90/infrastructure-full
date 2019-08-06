package me.jastz.json.result;

import me.jastz.common.json.JsonUtil;
import me.jastz.common.json.result.SampleResult;
import org.junit.Test;

/**
 * @author zhiwen
 */
public class SampleResultTest {

    @Test
    public void test() {
        System.out.println(JsonUtil.objectToPrettyJson(SampleResult.FAIL));
    }
}
