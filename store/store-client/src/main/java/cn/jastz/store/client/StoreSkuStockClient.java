package cn.jastz.store.client;

import cn.jastz.store.entity.StoreSkuStock;
import cn.jastz.store.form.StoreSkuStockForm;
import me.jastz.common.json.result.IResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zhiwen
 */
@FeignClient("store")
public interface StoreSkuStockClient {

    @GetMapping("store/sku/stock/list/{storeId}")
    List<StoreSkuStock> queryStoreSkuStockByStoreId(@PathVariable("storeId") int storeId);

    @PutMapping("store/sku/stock/updateSkuStock")
    IResult updateSkuStock(@RequestBody StoreSkuStockForm storeSkuStockForm);

    @PutMapping("store/sku/stock/updateSkuPrice")
    IResult updateSkuPrice(@RequestBody StoreSkuStockForm storeSkuStockForm);
}
