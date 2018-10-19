package cn.jastz.open.mapper;

import cn.jastz.open.entity.AppSocialRef;

import java.util.List;

public interface AppSocialRefMapper {
    int deleteByPrimaryKey(String appId);

    int insert(AppSocialRef record);

    AppSocialRef selectByPrimaryKey(String appId);

    List<AppSocialRef> selectAll();

    int updateByPrimaryKey(AppSocialRef record);
}