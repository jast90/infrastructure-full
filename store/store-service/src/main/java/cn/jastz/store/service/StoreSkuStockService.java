package cn.jastz.store.service;

import cn.jastz.store.entity.StoreSkuStock;
import cn.jastz.store.mapper.StoreSkuStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
