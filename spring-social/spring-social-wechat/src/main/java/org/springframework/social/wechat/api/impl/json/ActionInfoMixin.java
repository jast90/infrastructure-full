package org.springframework.social.wechat.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.wechat.api.Scene;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ActionInfoMixin extends WechatObjectMixin {
    @JsonProperty("scene")
    private Scene scene;
}
