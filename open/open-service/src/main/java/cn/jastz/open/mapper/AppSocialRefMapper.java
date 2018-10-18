package cn.jastz.open.mapper;

import cn.jastz.open.entity.AppSocialRef;
import java.util.List;

public interface AppSocialRefMapper {
    int deleteByPrimaryKey(Integer appId);

    int insert(AppSocialRef record);

    AppSocialRef selectByPrimaryKey(Integer appId);

    List<AppSocialRef> selectAll();

    int updateByPrimaryKey(AppSocialRef record);
}