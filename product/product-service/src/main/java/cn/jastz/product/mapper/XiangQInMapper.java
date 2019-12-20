package cn.jastz.product.mapper;

import me.jastz.common.juejin.xiangqin.XiangQin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhangzhiwen on 2019/11/26
 **/
@Mapper
public interface XiangQInMapper {

    int batchAdd(List<XiangQin> xiangQinList);
}
