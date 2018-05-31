package org.springframework.social.weibo.api.impl.json;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.weibo.api.LimitTimeUnit;

@JsonIgnoreProperties(ignoreUnknown = true)
class ApiRateLimitMixin {

	String api;
	int limit;
	@JsonProperty("limit_time_unit")
	LimitTimeUnit limitTimeUnit;
	@JsonProperty("remaining_hits")
	int remainingHits;

}
