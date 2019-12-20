package me.jastz.common.juejin.xiangqin;

import java.util.List;

/**
 * @author zhangzhiwen on 2019/11/26
 **/
public interface XiangQinOperations {

    XiangQinResp page(String uid,String deviceId,String token,String topic,int page,int pageSize );

}
