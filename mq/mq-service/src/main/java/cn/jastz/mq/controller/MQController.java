package cn.jastz.mq.controller;

import cn.jastz.mq.entity.Message;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiwen
 */
@RestController
@RequestMapping("mq")
public class MQController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate template;

    @PostMapping("send")
    public IResult send(@RequestBody Message message) {
        IResult result = SampleResult.FAIL;
        try {
            template.send(message.getTopic(), message.getMessage());
            result = SampleResult.SUCCESS;
        } catch (Exception e) {
            logger.error("Send kafka MQ error:", e);
        }
        return result;
    }
}
