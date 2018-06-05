package cn.jastz.open.mapper;

import cn.jastz.open.entity.App;
import java.util.List;

public interface AppMapper {
    int deleteByPrimaryKey(String appId);

    int insert(App record);

    App selectByPrimaryKey(String appId);

    List<App> selectAll();

    int updateByPrimaryKey(App record);
}