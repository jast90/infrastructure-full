package cn.jastz.product.mapper;

import cn.jastz.product.entity.ProductSkuAttrRef;
import cn.jastz.product.vo.ProductSkuAttrRefVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductSkuAttrRefMapper {
    int deleteByPrimaryKey(Integer refId);

    int insert(ProductSkuAttrRef record);

    int batchInsert(List<ProductSkuAttrRef> records);

    ProductSkuAttrRef selectByPrimaryKey(Integer refId);

    ProductSkuAttrRef selectByProductIdAndSkuAttrIdAndSkuAttrValue(@Param("productId") Integer productId
            ,@Param("skuAttrId")Integer skuAttrId
            ,@Param("skuAttrValue")String skuAttrValue);

    List<ProductSkuAttrRef> selectAll();

    int updateByPrimaryKey(ProductSkuAttrRef record);

    List<ProductSkuAttrRefVo> queryProductSkuAttrRefVoByProductId(Integer productId);


}