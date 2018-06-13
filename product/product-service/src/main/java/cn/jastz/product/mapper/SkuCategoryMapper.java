package cn.jastz.product.mapper;

import cn.jastz.product.entity.SkuCategory;

import java.util.List;

public interface SkuCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(SkuCategory record);

    SkuCategory selectByPrimaryKey(Integer categoryId);

    List<SkuCategory> selectAll();

    int updateByPrimaryKey(SkuCategory record);
}