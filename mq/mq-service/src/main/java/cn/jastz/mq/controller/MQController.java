package cn.jastz.mq.controller;

import cn.jastz.mq.entity.Message;
import cn.jastz.mq.result.MQFailResult;
import me.jastz.common.json.JsonUtil;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author zhiwen
 */
@RestController
@RequestMapping("/ignore/mq")
public class MQController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate template;

    @PostMapping("send")
    public IResult send(@RequestBody Message message) {
        logger.info("send mq:{}", JsonUtil.objectToPrettyJson(message));
        IResult result;
        ListenableFuture<SendResult<String, Message>> future = template.send(message.getTopic(), message.getMessage());
        try {
            SendResult<String, Message> sendResult = future.get(5, TimeUnit.SECONDS);
            result = SampleResult.SUCCESS;
        } catch (InterruptedException e) {
            logger.error("InterruptedException", e);
            result = MQFailResult.ERROR;
        } catch (ExecutionException e) {
            logger.error("ExecutionException", e);
            result = MQFailResult.ERROR;
        } catch (TimeoutException e) {
            logger.error("TimeoutException", e);
            result = MQFailResult.TIMEOUT;
        }
        return result;
    }
}
