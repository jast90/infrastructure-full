package cn.jastz.product.mapper;

import cn.jastz.product.entity.Sku;
import cn.jastz.product.vo.SkuProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuMapper {
    int deleteByPrimaryKey(Integer skuId);

    int insert(Sku record);

    Sku selectByPrimaryKey(Integer skuId);

    List<Sku> selectAll();

    int updateByPrimaryKey(Sku record);

    List<SkuProductVo> selectListByIds(@Param("ids") List<Integer> ids);

    List<Sku> selectListByProductId(@Param("productId") int productId);
}