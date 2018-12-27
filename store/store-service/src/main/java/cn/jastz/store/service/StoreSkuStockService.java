package cn.jastz.store.service;

import cn.jastz.store.entity.StoreSkuStock;
import cn.jastz.store.mapper.StoreSkuStockMapper;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhiwen
 */
@Service
public class StoreSkuStockService {

    @Autowired
    private StoreSkuStockMapper storeSkuStockMapper;

    public List<StoreSkuStock> queryStoreSkuStoreByStoreId(int storeId) {
        return storeSkuStockMapper.selectListByStoreId(storeId);
    }

    public IResult updateStockByStoreIdAndSkuId(int storeId, int productId, int skuId, BigDecimal skuStock) {
        StoreSkuStock storeSkuStock = new StoreSkuStock(productId, storeId, skuId);
        storeSkuStock.setSkuStock(skuStock);
        if (storeSkuStockMapper.updateByPrimaryKey(storeSkuStock) > 0) {
            return SampleResult.SUCCESS;
        }
        return SampleResult.FAIL;
    }

    public IResult updatePriceByStoreIdAndSkuId(int storeId, int productId, int skuId, BigDecimal price) {
        StoreSkuStock storeSkuStock = new StoreSkuStock(productId, storeId, skuId);
        storeSkuStock.setSkuPrice(price);
        if (storeSkuStockMapper.updateByPrimaryKey(storeSkuStock) > 0) {
            return SampleResult.SUCCESS;
        }
        return SampleResult.FAIL;
    }
}
