package cn.jastz;

import cn.jastz.mqtt.client.MqttSenderUtil;
import cn.jastz.mqtt.client.MqttTemplate;
import cn.jastz.mqtt.client.MyMessage;
import me.jastz.common.json.JsonUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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


    @Test
    public void sendMessage(){
        MqttTemplate mqttTemplate = new MqttTemplate();
        String msg = "openDoor deviceId-01";
        MyMessage myMessage = new MyMessage("deviceId-01",msg);
        ListenableFuture<ResultMsg> resultMsgListenableFuture = mqttTemplate.send(myMessage,ResultMsg.class,120, TimeUnit.SECONDS);
        resultMsgListenableFuture.addCallback(new ListenableFutureCallback<ResultMsg>() {
            @Override
            public void onFailure(Throwable ex) {

            }

            @Override
            public void onSuccess(ResultMsg result) {
                logger.info("get message:{}",JsonUtil.objectToJson(result));
            }
        });
    }

}
