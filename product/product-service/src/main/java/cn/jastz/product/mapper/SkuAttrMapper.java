package cn.jastz.product.mapper;

import cn.jastz.product.entity.SkuAttr;

import java.util.List;

public interface SkuAttrMapper {
    int deleteByPrimaryKey(Integer skuAttrId);

    int insert(SkuAttr record);

    SkuAttr selectByPrimaryKey(Integer skuAttrId);

    List<SkuAttr> selectAll();

    List<SkuAttr> selectAllByAppId(String appId);

    int updateByPrimaryKey(SkuAttr record);
}