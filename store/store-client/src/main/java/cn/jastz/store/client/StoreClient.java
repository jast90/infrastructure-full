package cn.jastz.store.client;

import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageRequest;
import cn.jastz.store.entity.Store;
import cn.jastz.store.form.StoreAddForm;
import cn.jastz.store.form.StoreAddSkuForm;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhiwen
 */
@FeignClient("store")
public interface StoreClient {
    @PostMapping("store")
    BaseResult addStore(@RequestBody StoreAddForm storeAddForm);

    @PostMapping("store/batchAddStoreSku")
    BaseResult batchAddStoreSku(@RequestBody StoreAddSkuForm storeAddSkuForm);

    @PostMapping("store/page")
    Page<Store> queryPage(@RequestBody PageRequest pageRequest);
}
