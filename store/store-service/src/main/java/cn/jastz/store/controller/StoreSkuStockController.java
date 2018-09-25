package cn.jastz.store.controller;

import cn.jastz.store.entity.StoreSkuStock;
import cn.jastz.store.service.StoreSkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
