package cn.jastz.product.mapper;

import cn.jastz.product.entity.SkuAttrRef;

import java.util.List;

public interface SkuAttrRefMapper {
    int deleteByPrimaryKey(Integer refId);

    int insert(SkuAttrRef record);

    SkuAttrRef selectByPrimaryKey(Integer refId);

    List<SkuAttrRef> selectAll();

    int updateByPrimaryKey(SkuAttrRef record);
}