package cn.jastz.mq.client;

import cn.jastz.mq.entity.Message;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhiwen
 */
@FeignClient("MQ")
public interface MQClient {
    /**
     * 发送MQ
     *
     * @param message
     * @return
     */
    @PostMapping("/mq/send")
    BaseResult sendMQ(@RequestBody Message message);
}
