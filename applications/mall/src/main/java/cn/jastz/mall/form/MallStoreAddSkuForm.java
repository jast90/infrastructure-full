package cn.jastz.mall.form;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author zhiwen
 */
public class MallStoreAddSkuForm {

    private int storeId;
    private List<MallStoreAddSkuItem> storeAddSkuItems;

    public List<Integer> skuIdList() {
        List<Integer> skuIdList = Lists.newArrayList();
        storeAddSkuItems.forEach(storeAddSkuItem -> skuIdList.add(storeAddSkuItem.getSkuId()));
        return skuIdList;
    }

    public Map<Integer, MallStoreAddSkuItem> map() {
        Map<Integer, MallStoreAddSkuItem> map = Maps.newHashMap();
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

    public List<MallStoreAddSkuItem> getStoreAddSkuItems() {
        return storeAddSkuItems;
    }

    public void setStoreAddSkuItems(List<MallStoreAddSkuItem> storeAddSkuItems) {
        this.storeAddSkuItems = storeAddSkuItems;
    }


    public static class MallStoreAddSkuItem {
        private int skuId;
        private BigDecimal storePrice;
        private Long stock;

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

        public Long getStock() {
            return stock;
        }

        public void setStock(Long stock) {
            this.stock = stock;
        }
    }
}
