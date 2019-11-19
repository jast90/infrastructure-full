package cn.jastz.mall.service;

import cn.jastz.mall.form.MallStoreAddSkuForm;
import cn.jastz.mall.result.MallResult;
import cn.jastz.mall.vo.StoreSkuProductStockVo;
import cn.jastz.product.client.ProductClient;
import cn.jastz.product.client.SkuClient;
import cn.jastz.product.entity.Sku;
import cn.jastz.product.vo.SkuProductVo;
import cn.jastz.store.client.StoreClient;
import cn.jastz.store.entity.StoreSkuStock;
import cn.jastz.store.form.StoreAddSkuForm;
import com.google.common.collect.Lists;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhiwen
 */
@Service
public class StoreService {
    @Autowired
    private StoreClient storeClient;

    @Autowired
    private SkuClient skuClient;

    @Autowired
    private ProductClient productClient;

    public IResult batchAddStoreSku(MallStoreAddSkuForm mallStoreAddSkuForm) {
        StoreAddSkuForm storeAddSkuForm = new StoreAddSkuForm();
        List<StoreAddSkuForm.StoreAddSkuItem> storeAddSkuItems = Lists.newArrayList();
        storeAddSkuForm.setStoreId(mallStoreAddSkuForm.getStoreId());
        List<SkuProductVo> skus = skuClient.queryListByIds(mallStoreAddSkuForm.skuIdList());
        Map<Integer, MallStoreAddSkuForm.MallStoreAddSkuItem> map = mallStoreAddSkuForm.map();
        for (Sku sku : skus) {
            MallStoreAddSkuForm.MallStoreAddSkuItem mallStoreAddSkuItem = map.get(sku.getSkuId());

            StoreAddSkuForm.StoreAddSkuItem storeAddSkuItem = new StoreAddSkuForm.StoreAddSkuItem();

            storeAddSkuItem.setProductId(sku.getProductId());
            storeAddSkuItem.setSkuId(sku.getSkuId());
            storeAddSkuItem.setStorePrice(mallStoreAddSkuItem != null && mallStoreAddSkuItem.getStorePrice() != null ? mallStoreAddSkuItem.getStorePrice() : sku.getPrice());
            storeAddSkuItem.setStock(mallStoreAddSkuItem.getStock());
            storeAddSkuItems.add(storeAddSkuItem);
        }
        storeAddSkuForm.setStoreAddSkuItems(storeAddSkuItems);
        if (storeClient.batchAddStoreSku(storeAddSkuForm).getResultCode() == MallResult.SUCCESS.getResultCode()) {
            return MallResult.SUCCESS;
        } else {
            return MallResult.FAIL;
        }
    }

    public List<StoreSkuProductStockVo> queryAllStoreSkuStockByStoreId(int storeId) {
        List<StoreSkuProductStockVo> storeSkuProductStockVos = Lists.newArrayList();
        List<StoreSkuStock> storeSkuStocks = storeClient.queryStoreSkuStockByStoreId(storeId);
        Set<Integer> skuIds = storeSkuStocks.stream().map(StoreSkuStock::getSkuId).collect(Collectors.toSet());
        List<SkuProductVo> skuProductVos = skuClient.queryListByIds(Lists.newArrayList(skuIds));
        Map<Integer, SkuProductVo> map = skuProductVos.stream().collect(Collectors.toMap(SkuProductVo::getSkuId, skuProductVo -> skuProductVo));
        storeSkuStocks.forEach(storeSkuStock -> {
            StoreSkuProductStockVo storeSkuProductStockVo = new StoreSkuProductStockVo();
            BeanUtils.copyProperties(storeSkuStock, storeSkuProductStockVo);
            storeSkuProductStockVo.setSkuProductVo(map.get(storeSkuStock.getSkuId()));
            storeSkuProductStockVos.add(storeSkuProductStockVo);
        });
        return storeSkuProductStockVos;
    }
}
