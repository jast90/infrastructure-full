package cn.jastz.store.controller;

import cn.jastz.store.entity.StoreSkuStock;
import cn.jastz.store.form.StoreSkuStockForm;
import cn.jastz.store.service.StoreSkuStockService;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhiwen
 */
@RestController
@RequestMapping("store/sku/stock")
public class StoreSkuStockController {
    @Autowired
    private StoreSkuStockService storeSkuStockService;

    @GetMapping("list/{storeId}")
    public List<StoreSkuStock> queryStoreSkuStockByStoreId(@PathVariable("storeId") int storeId) {
        return storeSkuStockService.queryStoreSkuStoreByStoreId(storeId);
    }

    @PutMapping("updateSkuStock")
    public IResult updateSkuStock(@RequestBody StoreSkuStockForm storeSkuStockForm) {
        return storeSkuStockService.updateStockByStoreIdAndSkuId(storeSkuStockForm.getStoreId(), storeSkuStockForm.getProductId(), storeSkuStockForm.getSkuId(), storeSkuStockForm.getSkuStock());
    }

    @PutMapping("updateSkuPrice")
    public IResult updateSkuPrice(@RequestBody StoreSkuStockForm storeSkuStockForm) {
        return storeSkuStockService.updatePriceByStoreIdAndSkuId(storeSkuStockForm.getStoreId(), storeSkuStockForm.getProductId(), storeSkuStockForm.getSkuId(), storeSkuStockForm.getSkuStock());
    }
}
