package cn.jastz.product.mapper;

import cn.jastz.product.entity.ProductSkuAttrRef;

import java.util.List;

public interface ProductSkuAttrRefMapper {
    int deleteByPrimaryKey(Integer refId);

    int insert(ProductSkuAttrRef record);

    ProductSkuAttrRef selectByPrimaryKey(Integer refId);

    List<ProductSkuAttrRef> selectAll();

    int updateByPrimaryKey(ProductSkuAttrRef record);
}