package cn.jastz.store.mapper;

import cn.jastz.page.domain.PageList;
import cn.jastz.page.domain.PageRequest;
import cn.jastz.store.entity.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer storeId);

    int insert(Store record);

    Store selectByPrimaryKey(Integer storeId);

    List<Store> selectAll();

    int updateByPrimaryKey(Store record);

    PageList<Store> selectPage(@Param("pageRequest") PageRequest pageRequest);
}