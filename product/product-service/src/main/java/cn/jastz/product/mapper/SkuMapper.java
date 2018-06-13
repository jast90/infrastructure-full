package cn.jastz.product.mapper;

import cn.jastz.product.entity.Sku;

import java.util.List;

public interface SkuMapper {
    int deleteByPrimaryKey(Integer skuId);

    int insert(Sku record);

    Sku selectByPrimaryKey(Integer skuId);

    List<Sku> selectAll();

    int updateByPrimaryKey(Sku record);
}