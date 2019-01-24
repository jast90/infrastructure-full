package cn.jastz.payment.service.pay;

import cn.jastz.open.enums.AttrName;
import cn.jastz.payment.config.MyWxPayConfig;
import cn.jastz.payment.entity.pay.ThirdPayCreateTradeParam;
import cn.jastz.payment.entity.pay.ThirdPayCreateTradeResult;
import cn.jastz.payment.entity.pay.ThirdPayMethod;
import cn.jastz.payment.entity.pay.WechatPayUnifieOrderResult;
import cn.jastz.payment.service.PaymentOrderService;
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
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private PaymentOrderService orderService;

    @Autowired
    private MyWxPayConfig myWxPayConfig;

    @Transactional
    @Override
    public ThirdPayCreateTradeResult createTrade(ThirdPayCreateTradeParam thirdPayCreateTradeParam) {
        //生成订单
        int orderId = orderService.saveMultiProductOrder(thirdPayCreateTradeParam.getAccountId(), thirdPayCreateTradeParam.getOrderItemVOS(), thirdPayCreateTradeParam.getTotalFee());

        //微信支付
        ThirdPayCreateTradeResult thirdPayCreateTradeResult = new ThirdPayCreateTradeResult();
        thirdPayCreateTradeResult.setThirdPayMethod(ThirdPayMethod.WECHAT_PAY);
        UnifiedOrderForm unifiedOrderForm = UnifiedOrderForm.UnifiedOrderFormBuilder.getInstance()
                .setAppId(wxTemplates.getWxPayConfig().getAppID())
                .setMchId(wxTemplates.getWxPayConfig().getMchID())
                .setBody(thirdPayCreateTradeParam.getTitle())
                .setOutTradeNo(String.valueOf(orderId))
                .setTotalFee(thirdPayCreateTradeParam.getTotalFee().multiply(new BigDecimal(100)).intValue())
                .setSpbillCreateIp(thirdPayCreateTradeParam.getSpbillCreateIp())
                .setNotifyUrl(myWxPayConfig.getAttrValue(AttrName.notify_url))
                .setTradeType(WxTradeType.valueOf(thirdPayCreateTradeParam.getTradeType()))
                .build();
        unifiedOrderForm.setOpenId(thirdPayCreateTradeParam.getOpenId());
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
