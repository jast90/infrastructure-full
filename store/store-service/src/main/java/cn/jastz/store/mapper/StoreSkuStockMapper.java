package cn.jastz.store.mapper;

import cn.jastz.store.entity.StoreSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreSkuStockMapper {
    int deleteByPrimaryKey(@Param("productId") Integer productId, @Param("storeId") Integer storeId, @Param("skuId") Integer skuId);

    int insert(StoreSkuStock record);

    StoreSkuStock selectByPrimaryKey(@Param("productId") Integer productId, @Param("storeId") Integer storeId, @Param("skuId") Integer skuId);

    List<StoreSkuStock> selectAll();

    int updateByPrimaryKey(StoreSkuStock record);

    int batchInsert(List<StoreSkuStock> storeSkuStockList);

    List<StoreSkuStock> selectListByStoreId(int storeId);
}