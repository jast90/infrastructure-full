package cn.jastz.product.service;

import cn.jastz.datasource.MyDataSource;
import cn.jastz.product.mapper.StackOverFlowUserMapper;
import me.jastz.common.stackoverflow.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangzhiwen on 2019/10/26
 **/
@Service
public class StackOverFlowService {
    @Autowired
    private StackOverFlowUserMapper stackOverFlowUserMapper;

    @MyDataSource(name="stack")
    public int insert(UserVo userVo){
        return stackOverFlowUserMapper.insert(userVo);
    }

    @MyDataSource(name="stack")
    public int batchInsert(List<UserVo> userVos){
        return stackOverFlowUserMapper.batchInsert(userVos);
    }
}
