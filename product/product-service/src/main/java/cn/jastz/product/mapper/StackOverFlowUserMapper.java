package cn.jastz.product.mapper;

import cn.jastz.datasource.MyDataSource;
import me.jastz.common.stackoverflow.vo.UserVo;

import java.util.List;

/**
 * @author zhangzhiwen on 2019/10/26
 **/
public interface StackOverFlowUserMapper {
    int insert(UserVo userVo);

    int batchInsert(List<UserVo> userVos);
}
