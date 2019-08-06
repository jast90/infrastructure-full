package me.jastz.common.http;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhiwen
 * @date 2017/10/31
 */
public class HttpUtil {

    /**
     * 获取当前发起请求的客户端是否是微信、支付宝
     *
     * @param httpServletRequest
     * @return
     */
    public AppType analyzeAppType(HttpServletRequest httpServletRequest) {
        String userAgent = httpServletRequest.getHeader("user-agent");
        if (userAgent == null) {
            return null;
        }
        if (userAgent.contains("MicroMessenger")) {
            return AppType.WEI_CHAT;
        } else if (userAgent.contains("AliApp") || userAgent.contains("AlipayClient") || userAgent.contains("Nebula PSDType")) {
            return AppType.ALI_PAY;
        } else {
            return null;
        }
    }
}
