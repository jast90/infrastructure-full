package me.jastz.common.qrcode;


import me.jastz.common.http.AppType;

/**
 * @author zhiwen
 * @date 2017/10/31
 */
public interface QrcodeContentFactory {

    /**
     * 生成二维码内容
     *
     * @param appType
     * @param requestParam
     * @return
     */
    String generateContent(AppType appType, RequestParam requestParam);
}
