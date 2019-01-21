package cn.jastz.payment.service.pay;

import cn.jastz.payment.entity.pay.ThirdPayCreateTradeParam;
import cn.jastz.payment.entity.pay.ThirdPayCreateTradeResult;
import cn.jastz.payment.entity.pay.ThirdPayMethod;
import cn.jastz.payment.entity.pay.WechatPayUnifieOrderResult;
import me.jastz.common.wx.WxTemplates;
import me.jastz.common.wx.wxpay.WxTradeType;
import me.jastz.common.wx.wxpay.entity.UnifiedOrderForm;
import me.jastz.common.wx.wxpay.entity.UnifiedOrderReturn;
import me.jastz.common.wx.wxpay.entity.UnifiedOrderReturnAndResultSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author zhiwen
 */
public class WechatPayTradeService implements TradeService {
    @Autowired
    private WxTemplates wxTemplates;
    @Value("${wx.pay.appId}")
    private String appId;
    @Value("${wx.pay.mchId}")
    private String mchId;
    @Value("${wx.pay.payKey}")
    private String payKey;

    @Override
    public ThirdPayCreateTradeResult createTrade(ThirdPayCreateTradeParam thirdPayCreateTradeParam) {

        thirdPayCreateTradeParam.setNonceStr(WxTemplates.WxPayUtil.generateNonceStr());
        thirdPayCreateTradeParam.setAppId(appId);
        thirdPayCreateTradeParam.setMchId(mchId);

        ThirdPayCreateTradeResult thirdPayCreateTradeResult = new ThirdPayCreateTradeResult();
        UnifiedOrderForm unifiedOrderForm = UnifiedOrderForm.UnifiedOrderFormBuilder.getInstance()
                .setAppId(thirdPayCreateTradeParam.getAppId())
                .setMchId(thirdPayCreateTradeParam.getMchId())
                .setNonceString(thirdPayCreateTradeParam.getNonceStr())
                .setSign(WxTemplates.WxPayUtil.generateMD5Sign(thirdPayCreateTradeParam.toWxPayMap(), payKey))
                .setBody(thirdPayCreateTradeParam.getTitle())
                .setOutTradeNo(thirdPayCreateTradeParam.getOutTradeNo())
                .setTotalFee(thirdPayCreateTradeParam.getTotalFee().multiply(new BigDecimal(100)).intValue())
                .setSpbillCreateIp(thirdPayCreateTradeParam.getSpbillCreateIp())
                .setNotifyUrl(thirdPayCreateTradeParam.getNotifyUrl())
                .setTradeType(WxTradeType.valueOf(thirdPayCreateTradeParam.getTradeType()))
                .build();
        UnifiedOrderReturn unifiedOrderReturn = wxTemplates.wxPayOperations().unifiedOrder(unifiedOrderForm);
        thirdPayCreateTradeResult.setThirdPayMethod(ThirdPayMethod.WECHAT_PAY);
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
