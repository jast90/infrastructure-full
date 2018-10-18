package cn.jastz.open.client;

import cn.jastz.open.entity.App;
import cn.jastz.open.entity.AppSocialRef;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhiwen
 */
@FeignClient("open")
public interface AppClient {

    @GetMapping("app/{appid}")
    App getById(@PathVariable("appid") String appid);

    @PostMapping("/app/socialRef")
    BaseResult addAppSocialRef(@RequestBody AppSocialRef appSocialRef);
}
