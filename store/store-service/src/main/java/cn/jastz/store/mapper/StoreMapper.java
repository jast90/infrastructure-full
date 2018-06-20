package cn.jastz.store.mapper;

import cn.jastz.store.entity.Store;

import java.util.List;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer storeId);

    int insert(Store record);

    Store selectByPrimaryKey(Integer storeId);

    List<Store> selectAll();

    int updateByPrimaryKey(Store record);
}