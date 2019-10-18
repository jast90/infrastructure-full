package cn.jastz;

import cn.jastz.mqtt.client.MqttSenderUtil;
import cn.jastz.mqtt.client.MyMessage;
import me.jastz.common.json.JsonUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MqttUtilTest {
    private static Logger logger = LoggerFactory.getLogger(MqttUtilTest.class);
     String broker = "tcp://localhost:1883";
     String mqttUtl = "mqttUtil";
     String deviceId = "123456";

    @Test
    public void test() {
        MyMessage<String> openDoor = new MyMessage<>("openDoor");
        Future<ResultMsg> result = MqttSenderUtil.getInstance(broker, mqttUtl).send(deviceId, openDoor, ResultMsg.class);
        ResultMsg msg = null;
        try {
            msg = result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        logger.info("{}", JsonUtil.objectToJson(msg));
    }

}
