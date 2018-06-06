package cn.jastz.account.client;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author zhiwen
 */
@FeignClient("account")
public interface AccountClient {

}
