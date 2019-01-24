package cn.jastz.payment.client;

import cn.jastz.payment.entity.pay.ThirdPayCreateTradeParam;
import cn.jastz.payment.entity.pay.ThirdPayCreateTradeResult;
import me.jastz.common.json.result.IResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhiwen
 */
@FeignClient("payment")
public interface PaymentClient {

    @GetMapping("test")
    IResult test();

    /**
     * 统一下单
     *
     * @param thirdPayMethod
     * @param thirdPayCreateTradeParam
     * @return
     */
    @PostMapping("trade/create/{thirdPayMethod}")
    ThirdPayCreateTradeResult createThirdTrade(@PathVariable("thirdPayMethod") String thirdPayMethod, @RequestBody ThirdPayCreateTradeParam thirdPayCreateTradeParam);
}
