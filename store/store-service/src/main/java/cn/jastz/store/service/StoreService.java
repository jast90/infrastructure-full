package cn.jastz.store.service;

import cn.jastz.product.client.SkuClient;
import cn.jastz.product.entity.Sku;
import cn.jastz.store.entity.Store;
import cn.jastz.store.entity.StoreSkuStock;
import cn.jastz.store.form.StoreAddForm;
import cn.jastz.store.form.StoreAddSkuForm;
import cn.jastz.store.mapper.StoreMapper;
import cn.jastz.store.mapper.StoreSkuStockMapper;
import com.google.common.collect.Lists;
import me.jastz.common.amap.AMapTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhiwen
 */
@Service
public class StoreService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private AMapTemplate aMapTemplate;

    @Autowired
    private SkuClient skuClient;

    @Autowired
    private StoreSkuStockMapper storeSkuStockMapper;


    public boolean addStore(StoreAddForm storeAddForm) {
        Store store = storeAddForm.to();
        Point point = aMapTemplate.opsForGeo().singleGeoCode(store.getAddress());
        if (point == null) {
            logger.warn("Amap get point error.");
            return false;
        }
        store.setLongitude(new BigDecimal(point.getX()));
        store.setLatitude(new BigDecimal(point.getY()));
        return storeMapper.insert(store) > 0;
    }

    public boolean batchAddStoreSku(StoreAddSkuForm storeAddSkuForm) {
        List<Sku> skuList = skuClient.queryListByIds(storeAddSkuForm.skuIdList());
        List<StoreSkuStock> storeSkuStockList = Lists.newArrayList();
        Map<Integer, StoreAddSkuForm.StoreAddSkuItem> map = storeAddSkuForm.map();
        for (Sku sku : skuList) {
            StoreSkuStock storeSkuStock = new StoreSkuStock();
            storeSkuStock.setProductId(sku.getProductId());
            storeSkuStock.setSkuId(sku.getSkuId());
            storeSkuStock.setSkuPrice(map.get(sku.getSkuId()) != null ? map.get(sku.getSkuId()).getStorePrice() : sku.getPrice());
            storeSkuStock.setSkuStock(map.get(sku.getSkuId()) != null ? map.get(sku.getSkuId()).getStock() : BigDecimal.ZERO);
            storeSkuStock.setCreatedTime(new Date());
            storeSkuStock.setStoreId(storeAddSkuForm.getStoreId());
            storeSkuStockList.add(storeSkuStock);
        }
        return storeSkuStockMapper.batchInsert(storeSkuStockList) > 1;
    }
}
