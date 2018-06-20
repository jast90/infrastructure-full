package cn.jastz.store.form;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author zhiwen
 */
public class StoreAddSkuForm {
    private int storeId;
    private List<StoreAddSkuItem> storeAddSkuItems;

    public List<Integer> skuIdList() {
        List<Integer> skuIdList = Lists.newArrayList();
        storeAddSkuItems.forEach(storeAddSkuItem -> skuIdList.add(storeAddSkuItem.getSkuId()));
        return skuIdList;
    }

    public Map<Integer, StoreAddSkuItem> map() {
        Map<Integer, StoreAddSkuItem> map = Maps.newHashMap();
        storeAddSkuItems.forEach(storeAddSkuItem -> map.put(storeAddSkuItem.getSkuId(), storeAddSkuItem));
        return map;
    }

    /**
     * getter and setter
     */
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public List<StoreAddSkuItem> getStoreAddSkuItems() {
        return storeAddSkuItems;
    }

    public void setStoreAddSkuItems(List<StoreAddSkuItem> storeAddSkuItems) {
        this.storeAddSkuItems = storeAddSkuItems;
    }

    public static class StoreAddSkuItem {
        private int skuId;
        private BigDecimal storePrice;
        private BigDecimal stock;

        public int getSkuId() {
            return skuId;
        }

        public void setSkuId(int skuId) {
            this.skuId = skuId;
        }

        public BigDecimal getStorePrice() {
            return storePrice;
        }

        public void setStorePrice(BigDecimal storePrice) {
            this.storePrice = storePrice;
        }

        public BigDecimal getStock() {
            return stock;
        }

        public void setStock(BigDecimal stock) {
            this.stock = stock;
        }
    }
}
