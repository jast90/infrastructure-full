package cn.jastz.mall.store.service;

import cn.jastz.mall.service.StoreService;
import cn.jastz.mall.store.BaseTest;
import cn.jastz.mall.vo.StoreSkuProductStockVo;
import me.jastz.common.json.JsonUtil;
import org.junit.Test;

import java.util.List;

/**
 * @author zhiwen
 */
public class StoreServiceTest extends BaseTest<StoreService> {
    @Test
    public void addStore() {
        List<StoreSkuProductStockVo> list = service.queryAllStoreSkuStockByStoreId(1);
        System.out.println(JsonUtil.objectToJson(list));
    }

}
