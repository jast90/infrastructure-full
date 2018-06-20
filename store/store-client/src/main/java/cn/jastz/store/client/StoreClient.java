package cn.jastz.store.client;

import cn.jastz.store.form.StoreAddForm;
import cn.jastz.store.form.StoreAddSkuForm;
import me.jastz.common.json.result.IResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhiwen
 */
@FeignClient("store")
public interface StoreClient {
    @PostMapping("store")
    IResult addStore(@RequestBody StoreAddForm storeAddForm);

    @PostMapping("store/batchAddStoreSku")
    IResult batchAddStoreSku(@RequestBody StoreAddSkuForm storeAddSkuForm);
}
