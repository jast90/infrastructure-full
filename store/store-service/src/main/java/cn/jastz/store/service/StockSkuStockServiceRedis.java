package cn.jastz.store.service;

import cn.jastz.store.entity.StoreSkuStock;
import cn.jastz.store.form.StoreSkuStockForm;
import com.beust.jcommander.internal.Lists;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StockSkuStockServiceRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StockSkuStockService stockSkuStockService;

    /**
     * 加载数据到redis
     * @param storeId
     * @param productId
     * @param skuId
     */

    /**
     * 不支持分布式环境
     * @param storeId
     * @param productId
     * @param skuId
     */
    public synchronized void setStock(int storeId, int productId, int skuId){
        if(redisTemplate.hasKey(String.format("stock:%s:%s:%s",storeId,productId,skuId))){
            return;
        }
        StoreSkuStock storeSkuStock = stockSkuStockService.queryStoreSkuStockBySkuId(storeId,productId,skuId);
        redisTemplate.opsForValue().set(String.format("stock:%s:%s:%s",storeId,productId,skuId),storeSkuStock.getSkuStock());

    }

    /**
     *
     * redis中的库存，redis 商品库存键：stock:storeId:productId:skuId
     * 1. 预热redis中的商品库存，单线程调用：通过查询数据库
     * 2. 通过reduceBy扣件库存
     *
     * @param storeId
     * @param productId
     * @param skuId
     * @param skuStock
     * @return
     */
    public IResult reduceStockByStoreIdAndSkuId(int storeId, int productId, int skuId, long skuStock) {
        setStock(storeId,productId,skuId);
        String redisStockKey = String.format("stock:%s:%s:%s",storeId,productId,skuId);
        DefaultRedisScript<Long> script = new DefaultRedisScript<>();
        script.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/stockReduce.lua")));
        script.setResultType(Long.class);
        long result = (long) redisTemplate.execute(script, Lists.newArrayList(redisStockKey),skuStock);
        if(result >= 0){
            return SampleResult.SUCCESS;
        }
        return SampleResult.FAIL;
    }

    public Map<Integer, IResult> orderReduceStocks(List<StoreSkuStockForm> storeSkuStockForms) {
        return null;
    }
}
