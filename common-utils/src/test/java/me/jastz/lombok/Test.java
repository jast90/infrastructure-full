package me.jastz.lombok;

import me.jastz.common.json.JsonUtil;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @author zhiwen
 */
public class Test {
    @org.junit.Test
    public void test() {
        TimeVo timeVo = new TimeVo();
        timeVo.setT(new Timestamp(Calendar.getInstance().getTime().getTime()));
        System.out.println(JsonUtil.objectToJson(timeVo));
    }
}
