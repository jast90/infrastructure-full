package cn.jastz.account.mapper;

import cn.jastz.account.entity.AccountSocialRef;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountSocialRefMapper {
    int deleteByPrimaryKey(@Param("accountId") Integer accountId, @Param("social") String social);

    int insert(AccountSocialRef record);

    AccountSocialRef selectByPrimaryKey(@Param("accountId") Integer accountId, @Param("social") String social);

    List<AccountSocialRef> selectAll();

    int updateByPrimaryKey(AccountSocialRef record);

    AccountSocialRef selectByUserNameAndSocial(@Param("username")String username, @Param("social")String social);
}