package cn.jastz.open.client;

import cn.jastz.open.entity.AppPayConfig;
import cn.jastz.open.enums.PayPlatform;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zhiwen
 */
@FeignClient("open")
public interface AppPayConfigClient {
    @GetMapping("app/pay/config")
    List<AppPayConfig> getByAppId();

    @GetMapping("app/pay/config/{payPlatform}")
    AppPayConfig getByAppIdAndPayPlatform(@PathVariable("payPlatform") PayPlatform payPlatform);
}
