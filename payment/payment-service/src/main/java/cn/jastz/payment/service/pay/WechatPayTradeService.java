package cn.jastz.payment.service.pay;

import cn.jastz.payment.entity.pay.ThirdPayCreateTradeParam;
import cn.jastz.payment.entity.pay.ThirdPayCreateTradeResult;
import cn.jastz.payment.entity.pay.ThirdPayMethod;
import cn.jastz.payment.entity.pay.WechatPayUnifieOrderResult;
import me.jastz.common.json.JsonUtil;
import me.jastz.common.wx.WxTemplates;
import me.jastz.common.wx.wxpay.WxTradeType;
import me.jastz.common.wx.wxpay.entity.UnifiedOrderForm;
import me.jastz.common.wx.wxpay.entity.UnifiedOrderReturn;
import me.jastz.common.wx.wxpay.entity.UnifiedOrderReturnAndResultSuccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author zhiwen
 */
@Service
public class WechatPayTradeService implements TradeService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WxTemplates wxTemplates;
    @Value("${wx.pay.appID}")
    private String appId;
    @Value("${wx.pay.mchID}")
    private String mchId;
    @Value("${wx.pay.key}")
    private String payKey;

    @Override
    public ThirdPayCreateTradeResult createTrade(ThirdPayCreateTradeParam thirdPayCreateTradeParam) {
        ThirdPayCreateTradeResult thirdPayCreateTradeResult = new ThirdPayCreateTradeResult();
        thirdPayCreateTradeResult.setThirdPayMethod(ThirdPayMethod.WECHAT_PAY);
        UnifiedOrderForm unifiedOrderForm = UnifiedOrderForm.UnifiedOrderFormBuilder.getInstance()
                .setAppId(appId)
                .setMchId(mchId)
//                .setNonceString(WxTemplates.WxPayUtil.generateNonceStr())//
                .setBody(thirdPayCreateTradeParam.getTitle())
                .setOutTradeNo(thirdPayCreateTradeParam.getOutTradeNo())
                .setTotalFee(thirdPayCreateTradeParam.getTotalFee().multiply(new BigDecimal(100)).intValue())
                .setSpbillCreateIp(thirdPayCreateTradeParam.getSpbillCreateIp())
                .setNotifyUrl(thirdPayCreateTradeParam.getNotifyUrl())
                .setTradeType(WxTradeType.valueOf(thirdPayCreateTradeParam.getTradeType()))
                .build();
        unifiedOrderForm.setOpenId(thirdPayCreateTradeParam.getOpenId());
//        unifiedOrderForm.setSign(WxTemplates.WxPayUtil.generateMD5Sign(unifiedOrderForm.toMap(), payKey));
        UnifiedOrderReturn unifiedOrderReturn = wxTemplates.wxPayOperations().unifiedOrder(unifiedOrderForm);
        logger.debug("wechat pay unified order result:{}", JsonUtil.objectToPrettyJson(unifiedOrderReturn));
        WechatPayUnifieOrderResult wechatPayUnifieOrderResult = new WechatPayUnifieOrderResult();
        if (unifiedOrderReturn instanceof UnifiedOrderReturnAndResultSuccess) {
            UnifiedOrderReturnAndResultSuccess unifiedOrderReturnAndResultSuccess = (UnifiedOrderReturnAndResultSuccess) unifiedOrderReturn;
            wechatPayUnifieOrderResult.setAppId(unifiedOrderReturnAndResultSuccess.getAppId());
            wechatPayUnifieOrderResult.setSignType(unifiedOrderReturnAndResultSuccess.getSign());
            wechatPayUnifieOrderResult.setNonceStr(unifiedOrderReturnAndResultSuccess.getNonceStr());
            wechatPayUnifieOrderResult.setPrepayId(unifiedOrderReturnAndResultSuccess.getPrepayId());
            wechatPayUnifieOrderResult.setPaySign(unifiedOrderReturnAndResultSuccess.getSign());
            wechatPayUnifieOrderResult.setTimestamp(new Timestamp(System.currentTimeMillis()));
            thirdPayCreateTradeResult.setWechatPayUnifieOrderResult(wechatPayUnifieOrderResult);
        }
        return thirdPayCreateTradeResult;
    }
}
