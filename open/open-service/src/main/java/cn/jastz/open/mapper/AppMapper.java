package cn.jastz.open.mapper;

import cn.jastz.open.entity.App;
import cn.jastz.page.domain.PageRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppMapper {
    int deleteByPrimaryKey(String appId);

    int insert(App record);

    App selectByPrimaryKey(String appId);

    List<App> selectAll();

    int updateByPrimaryKey(App record);

    List<App> queryPage(@Param("pageRequest") PageRequest pageRequest);
}