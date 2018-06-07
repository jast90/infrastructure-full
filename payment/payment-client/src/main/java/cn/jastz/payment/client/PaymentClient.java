package cn.jastz.payment.client;

import me.jastz.common.json.result.IResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhiwen
 */
@FeignClient("payment")
public interface PaymentClient {
    @GetMapping("test")
    IResult test();
}
