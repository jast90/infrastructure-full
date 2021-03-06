package cn.jastz.store.controller;

import cn.jastz.store.entity.StoreSkuStock;
import cn.jastz.store.form.StoreSkuStockForm;
import cn.jastz.store.service.StockSkuStockService;
import cn.jastz.store.service.StockSkuStockServiceRedis;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zhiwen
 */
@RestController
@RequestMapping("store/sku/stock")
public class StoreSkuStockController {
    @Autowired
    private StockSkuStockService storeSkuStockService;

    @Autowired
    private StockSkuStockServiceRedis stockSkuStockServiceRedis;

    @GetMapping("list/{storeId}")
    public List<StoreSkuStock> queryStoreSkuStockByStoreId(@PathVariable("storeId") int storeId) {
        return storeSkuStockService.queryStoreSkuStoreByStoreId(storeId);
    }

    @PutMapping("updateSkuStock")
    public IResult updateSkuStock(@RequestBody StoreSkuStockForm storeSkuStockForm) {
        return storeSkuStockService.reduceStockByStoreIdAndSkuId(storeSkuStockForm.getStoreId(),
                storeSkuStockForm.getProductId(), storeSkuStockForm.getSkuId(), storeSkuStockForm.getSkuStock());
    }

    /**
     * 通过redis扣减库存（不支持分布式环境）
     * @param storeSkuStockForm
     * @return
     */
    @PutMapping("reduceSkuStock")
    public IResult reduceSkuStock(@RequestBody StoreSkuStockForm storeSkuStockForm){
        return stockSkuStockServiceRedis.reduceStockByStoreIdAndSkuId(storeSkuStockForm.getStoreId(),
                storeSkuStockForm.getProductId(), storeSkuStockForm.getSkuId(), storeSkuStockForm.getSkuStock());
    }


    @PutMapping("orderReduceStocks")
    public Map<Integer,IResult> orderReduceStocks(@RequestBody List<StoreSkuStockForm> storeSkuStockForms) {
        return storeSkuStockService.orderReduceStocks(storeSkuStockForms);
    }

    @GetMapping("/{storeId}/{productId}/{skuId}")
    public IResult subStockByOrder(@PathVariable("storeId") int storeId,@PathVariable("productId") int productId,
                                   @PathVariable("skuId") int skuId){
        System.out.println(storeSkuStockService);
        return storeSkuStockService.reduceStockByStoreIdAndSkuId(storeId,productId,skuId,1);
    }

    @PutMapping("updateSkuPrice")
    public IResult updateSkuPrice(@RequestBody StoreSkuStockForm storeSkuStockForm) {
        return storeSkuStockService.updatePriceByStoreIdAndSkuId(storeSkuStockForm.getStoreId(), storeSkuStockForm.getProductId(), storeSkuStockForm.getSkuId(), storeSkuStockForm.getSkuPrice());
    }
}
