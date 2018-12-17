package cn.jastz.account.mapper;

import cn.jastz.account.entity.AccountPassword;
import java.util.List;

public interface AccountPasswordMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(AccountPassword record);

    AccountPassword selectByPrimaryKey(Integer accountId);

    List<AccountPassword> selectAll();

    int updateByPrimaryKey(AccountPassword record);
}