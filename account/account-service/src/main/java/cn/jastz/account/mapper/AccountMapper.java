package cn.jastz.account.mapper;

import cn.jastz.account.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    Account selectByPrimaryKey(Integer accountId);

    Account selectByUsernameAndAccountFrom(@Param("username") String username, @Param("accountFrom")String accountFrom);

    List<Account> selectAll();

    int updateByPrimaryKey(Account record);
}