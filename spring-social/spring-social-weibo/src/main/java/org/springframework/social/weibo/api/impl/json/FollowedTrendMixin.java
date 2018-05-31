package org.springframework.social.weibo.api.impl.json;


import com.fasterxml.jackson.annotation.JsonProperty;

abstract class FollowedTrendMixin {

	@JsonProperty("trend_id")
	long trendId;
	@JsonProperty("is_follow")
	boolean followed;

}
