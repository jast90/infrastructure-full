package org.springframework.social.wechat.api.impl.json;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class WechatObjectMixin {
    @JsonIgnore
    Map<String, Object> extraData;

    @JsonAnySetter
    abstract void add(String key, Object value);
}
