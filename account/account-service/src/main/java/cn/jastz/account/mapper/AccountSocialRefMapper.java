package cn.jastz.account.mapper;

import cn.jastz.account.entity.AccountSocialRef;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountSocialRefMapper {
    int deleteByPrimaryKey(@Param("accountId") Integer accountId, @Param("social") String social, @Param("appId") String appId);

    int insert(AccountSocialRef record);

    AccountSocialRef selectByPrimaryKey(@Param("accountId") Integer accountId, @Param("social") String social, @Param("appId") String appId);

    List<AccountSocialRef> selectAll();

    int updateByPrimaryKey(AccountSocialRef record);

    AccountSocialRef selectByUserNameAndSocialAndAppId(@Param("username") String username, @Param("social") String social, @Param("appId") String appId);
}