package org.springframework.social.weibo.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.weibo.api.ApiRateLimit;
import org.springframework.social.weibo.api.LimitTimeUnit;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class RateLimitStatusMixin {

	@JsonProperty("ip_limit")
	int ipLimit;
	@JsonProperty("limit_time_unit")
	LimitTimeUnit limitTimeUnit;
	@JsonProperty("remaining_ip_hits")
	int remainingIpHits;
	@JsonProperty("remaining_user_hits")
	int remainingUserHits;
	@JsonProperty("reset_time")
	@JsonDeserialize(using = DateFormatDeserializer.class)
	Date resetTime;
	@JsonProperty("reset_time_in_seconds")
	int resetTimeInSeconds;
	@JsonProperty("user_limit")
	int userLimit;
	@JsonProperty("api_rate_limits")
	List<ApiRateLimit> apiRateLimits;

}
