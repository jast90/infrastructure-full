package cn.jastz.fatui.mapper;

import cn.jastz.fatui.entity.Store;
import cn.jastz.page.domain.PageList;
import cn.jastz.page.domain.PageRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface StoreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Store record);

    Store selectByPrimaryKey(Long id);

    List<Store> selectAll();

    int updateByPrimaryKey(Store record);

    PageList<Store> selectPage(@Param("pageRequest") PageRequest pageRequest, @Param("sort") Sort sort);
}