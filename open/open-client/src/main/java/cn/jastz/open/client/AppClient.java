package cn.jastz.open.client;

import cn.jastz.open.entity.App;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhiwen
 */
@FeignClient("open")
public interface AppClient {

    @GetMapping("app/{appid}")
    App getById(@PathVariable("appid") String appid);
}
