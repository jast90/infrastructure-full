package cn.jastz.fatui.form;

import cn.jastz.app.mini.wechat.domain.WxaUserInfo;

/**
 * @author zhangzhiwen on 2019/12/20
 **/
public class CodeForm {
    private String code;
    private WxaUserInfo wxaUserInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public WxaUserInfo getWxaUserInfo() {
        return wxaUserInfo;
    }

    public void setWxaUserInfo(WxaUserInfo wxaUserInfo) {
        this.wxaUserInfo = wxaUserInfo;
    }
}
