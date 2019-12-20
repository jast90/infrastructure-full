package cn.jastz.product.service;

import cn.jastz.datasource.MyDataSource;
import cn.jastz.product.mapper.XiangQInMapper;
import me.jastz.common.juejin.xiangqin.XiangQin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangzhiwen on 2019/11/26
 **/
@Service
public class JueJinService {
    @Autowired
    private XiangQInMapper xiangQInMapper;


    @MyDataSource(name="juejin")
    public int batchAdd(List<XiangQin> list){
        return xiangQInMapper.batchAdd(list);
    }

}
