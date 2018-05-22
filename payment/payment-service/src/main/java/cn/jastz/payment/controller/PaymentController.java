package cn.jastz.payment.controller;

import cn.jastz.payment.service.PaymentOrderService;
import me.jastz.common.wx.WxTemplates;
import me.jastz.common.wx.wxpay.WxTradeType;
import me.jastz.common.wx.wxpay.entity.UnifiedOrderForm;
import me.jastz.common.wx.wxpay.entity.UnifiedOrderReturn;
import me.jastz.common.wx.wxpay.entity.UnifiedOrderReturnAndResultSuccess;
import me.jastz.common.zxing.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author zhiwen
 */
@Controller
public class PaymentController {

    @Autowired
    private WxTemplates wxTemplates;

    @Autowired
    private PaymentOrderService orderService;


    @GetMapping("scanPay")
    public void scanPay(int accountId, int productId, String productName, BigDecimal payAmount, HttpServletResponse response) {
        int orderId = orderService.saveOneProductOrder(accountId, productId, productName, payAmount);
        UnifiedOrderForm unifiedOrderForm = UnifiedOrderForm.UnifiedOrderFormBuilder.getInstance()
                .setOutTradeNo(String.valueOf(orderId))
                .setBody(String.format("%s-%s", productName, 1))
                .setProductId(String.valueOf(productId))
                .setTotalFee(payAmount.multiply(new BigDecimal(100)).intValue())
                .setTradeType(WxTradeType.NATIVE)
                .build();
        UnifiedOrderReturn unifiedOrderReturn = wxTemplates.wxPayOperations().unifiedOrder(unifiedOrderForm);
        String codeUrl = "default";
        if (unifiedOrderReturn instanceof UnifiedOrderReturnAndResultSuccess) {
            codeUrl = ((UnifiedOrderReturnAndResultSuccess) unifiedOrderReturn).getCodeUrl();
        }
        response.setContentType("image/png");
        try {
            QRCodeUtil.writeToStream(codeUrl, 64, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
