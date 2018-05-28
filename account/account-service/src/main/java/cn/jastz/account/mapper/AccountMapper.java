package cn.jastz.account.mapper;

import cn.jastz.account.entity.Account;
import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    Account selectByPrimaryKey(Integer accountId);

    List<Account> selectAll();

    int updateByPrimaryKey(Account record);
}