package cn.jastz.product.mapper;

import cn.jastz.product.entity.Sku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuMapper {
    int deleteByPrimaryKey(Integer skuId);

    int insert(Sku record);

    Sku selectByPrimaryKey(Integer skuId);

    List<Sku> selectAll();

    int updateByPrimaryKey(Sku record);

    List<Sku> selectListByIds(@Param("ids") List<Integer> ids, @Param("appId") String appId);

    List<Sku> selectListByProductId(@Param("productId") int productId);
}