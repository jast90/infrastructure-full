package org.springframework.social.wechat.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.wechat.api.ActionInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class QuickResponseCodeRequestMixin extends WechatObjectMixin {
    @JsonProperty("expire_seconds")
    private Integer expireSeconds;
    @JsonProperty("action_name")
    private String actionName;
    @JsonProperty("action_info")
    private ActionInfo actionInfo;
}
