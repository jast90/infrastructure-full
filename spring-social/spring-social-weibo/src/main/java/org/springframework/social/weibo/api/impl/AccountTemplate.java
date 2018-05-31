package org.springframework.social.weibo.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.social.weibo.api.AccountOperations;
import org.springframework.social.weibo.api.RateLimitStatus;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

class AccountTemplate extends AbstractWeiboOperations implements
		AccountOperations {

	protected AccountTemplate(ObjectMapper objectMapper,
			RestTemplate restTemplate, boolean isAuthorized) {
		super(objectMapper, restTemplate, isAuthorized);
	}

	@Override
	public long getUid() {
		requireAuthorization();
		return Long.valueOf(restTemplate
				.getForObject(buildUri("account/get_uid.json"), Map.class)
				.get("uid").toString());
	}

	@Override
	public RateLimitStatus getRateLimitStatus() {
		requireAuthorization();
		return restTemplate.getForObject(
				buildUri("account/rate_limit_status.json"),
				RateLimitStatus.class);
	}
}
