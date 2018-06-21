package cn.jastz.product.mapper;

import cn.jastz.product.entity.Product;
import cn.jastz.product.vo.ProductSkuVo;
import cn.jastz.product.vo.ProductVo;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    Product selectByPrimaryKey(Integer productId);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);

    ProductVo queryProductVoByPrimaryKey(Integer productId);

    List<ProductSkuVo> queryAllProductSkuVo();
}