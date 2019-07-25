package cn.jastz.open.mapper;

import cn.jastz.open.entity.AppSocialRef;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppSocialRefMapper {
    int deleteByPrimaryKey(String appId);

    int insert(AppSocialRef record);

    AppSocialRef selectByPrimaryKey(String appId);

    List<AppSocialRef> selectAll();

    int updateByPrimaryKey(AppSocialRef record);
}
