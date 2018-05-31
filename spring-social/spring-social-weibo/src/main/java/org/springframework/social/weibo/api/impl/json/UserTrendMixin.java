package org.springframework.social.weibo.api.impl.json;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class UserTrendMixin {

	String num;
	String hotword;
	@JsonProperty("trend_id")
	long id;

}
