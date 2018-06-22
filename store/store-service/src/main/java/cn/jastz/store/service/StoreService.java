package cn.jastz.store.service;

import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageList;
import cn.jastz.page.domain.PageRequest;
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
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
        List<StoreSkuStock> storeSkuStockList = Lists.newArrayList();
        if (storeAddSkuForm.getStoreAddSkuItems() == null) {
            return false;
        }
        for (StoreAddSkuForm.StoreAddSkuItem storeAddSkuItem : storeAddSkuForm.getStoreAddSkuItems()) {
            StoreSkuStock storeSkuStock = new StoreSkuStock();
            storeSkuStock.setProductId(storeAddSkuItem.getProductId());
            storeSkuStock.setSkuId(storeAddSkuItem.getSkuId());
            storeSkuStock.setSkuPrice(storeAddSkuItem.getStorePrice());
            storeSkuStock.setSkuStock(storeAddSkuItem.getStock());
            storeSkuStock.setCreatedTime(new Date());
            storeSkuStock.setStoreId(storeAddSkuForm.getStoreId());
            storeSkuStockList.add(storeSkuStock);
        }
        if (CollectionUtils.isEmpty(storeSkuStockList)) {
            logger.warn("StoreSkuStockList is empty.");
            return false;
        }
        return storeSkuStockMapper.batchInsert(storeSkuStockList) > 0;
    }

    public Page<Store> queryPage(PageRequest pageRequest) {
        PageList pageList = (PageList) storeMapper.selectPage(pageRequest);
        return pageList.getPage();
    }
}
