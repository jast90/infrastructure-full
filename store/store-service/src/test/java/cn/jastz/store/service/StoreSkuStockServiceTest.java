package cn.jastz.store.service;

import cn.jastz.store.BaseTest;
import me.jastz.common.json.result.IResult;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangzhiwen on 2019/11/2
 **/
public class StoreSkuStockServiceTest extends BaseTest<StockSkuStockServiceRedis> {

    @Test
    @Transactional
    public void multiThreadReduceStock(){
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                log.error("thread:{},message:{},e:{}",t.getName(),e.getMessage(),e);
            }
        });
        int storeId = 1;
        int productId = 1;
        int skuId = 2;
//        IResult iResult = service.reduceStockByStoreIdAndSkuId(storeId,productId,skuId,null);
//        log.debug("result:{}", JsonUtil.objectToJson(iResult));
        for(int i = 0;i<100;i++){
            threadPoolExecutor.submit(()->{
                IResult iResult = service.reduceStockByStoreIdAndSkuId(storeId,productId,skuId, -1);
            });
        }
        threadPoolExecutor.shutdown();
        while (true){
            if(threadPoolExecutor.isTerminated()){
                break;
            }
        }
    }


}
