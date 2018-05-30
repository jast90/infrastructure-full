package org.springframework.social.wechat.api.impl.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.social.wechat.api.*;

public class WechatModule extends SimpleModule {
    private static final long serialVersionUID = 2187084305052393830L;

    public WechatModule() {
        super("WechatModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(AccessToken.class, AccessTokenMixin.class);
        context.setMixInAnnotations(ActionInfo.class, ActionInfoMixin.class);
        context.setMixInAnnotations(QuickResponseCodeRequest.class, QuickResponseCodeRequestMixin.class);
        context.setMixInAnnotations(QuickResponseCodeTicket.class, QuickResponseCodeTicketMixin.class);
        context.setMixInAnnotations(Scene.class, SceneMixin.class);
        context.setMixInAnnotations(WechatObject.class, WechatObjectMixin.class);
        context.setMixInAnnotations(ValueColorPair.class, ValueColorPairMixin.class);
        context.setMixInAnnotations(ErrorCode.class, ErrorCodeMixin.class);
    }
}
