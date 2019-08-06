package me.jastz.common.alipay.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import me.jastz.common.alipay.AlipayOperations;
import me.jastz.common.alipay.AlipayProperties;
import me.jastz.common.alipay.domain.AliPayResult;
import me.jastz.common.alipay.domain.TradeCreateParam;
import me.jastz.common.alipay.domain.TradeCreateResult;
import me.jastz.common.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhiwen
 */
public class AlipayOperationsImpl implements AlipayOperations {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private AlipayProperties alipayProperties;

    @Override
    public AliPayResult<TradeCreateResult> tradeCreate(TradeCreateParam tradeCreateParam) {
        AliPayResult<TradeCreateResult> aliPayResult = new AliPayResult<>();

        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
        try {
            String bizContent = JsonUtil.objectToJson(tradeCreateParam);
            logger.debug("Alipay trade create param:{}", bizContent);
            request.setBizContent(bizContent);
            AlipayTradeCreateResponse response = getAlipayClient().execute(request);
            TradeCreateResult tradeCreateResult = new TradeCreateResult();
            tradeCreateResult.setCode(response.getCode());
            tradeCreateResult.setMsg(response.getMsg());
            if (response.isSuccess()) {
                tradeCreateResult.setTrade_no(response.getTradeNo());
                tradeCreateResult.setOut_trade_no(response.getOutTradeNo());
            }
            aliPayResult.setT(tradeCreateResult);
        } catch (AlipayApiException e) {
            logger.debug("Alipay trade create error:", e);
        }
        return aliPayResult;
    }

    private AlipayClient getAlipayClient() {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", alipayProperties.getAppId(), alipayProperties.getPrivateKey(), "json", "GBK", alipayProperties.getAliPublicKey(), "RSA2");
        return alipayClient;
    }
}
