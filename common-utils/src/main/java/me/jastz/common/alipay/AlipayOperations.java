package me.jastz.common.alipay;

import me.jastz.common.alipay.domain.AliPayResult;
import me.jastz.common.alipay.domain.TradeCreateParam;
import me.jastz.common.alipay.domain.TradeCreateResult;

/**
 * @author zhiwen
 */
public interface AlipayOperations {
    /**
     * 统一收单交易创建接口
     *
     * @param tradeCreateParam
     * @return
     */
    AliPayResult<TradeCreateResult> tradeCreate(TradeCreateParam tradeCreateParam);
}
