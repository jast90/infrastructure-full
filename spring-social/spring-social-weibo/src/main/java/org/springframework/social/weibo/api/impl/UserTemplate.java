package org.springframework.social.weibo.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.social.weibo.api.UserOperations;
import org.springframework.social.weibo.api.WeiboProfile;
import org.springframework.web.client.RestTemplate;

class UserTemplate extends AbstractWeiboOperations implements UserOperations {

	protected UserTemplate(ObjectMapper objectMapper,
			RestTemplate restTemplate, boolean isAuthorized) {
		super(objectMapper, restTemplate, isAuthorized);
	}

	@Override
	public WeiboProfile getUserProfileByDomainName(String domainName) {
		requireAuthorization();
		return restTemplate.getForObject(
				buildUri("users/domain_show.json", "domain", domainName),
				WeiboProfile.class);
	}

	@Override
	public WeiboProfile getUserProfileById(long uid) {
		requireAuthorization();
		return restTemplate.getForObject(
				buildUri("users/show.json", "uid", uid), WeiboProfile.class);
	}

	@Override
	public WeiboProfile getUserProfileByScreenName(String screenName) {
		requireAuthorization();
		return restTemplate.getForObject(
				buildUri("users/show.json", "screen_name", screenName),
				WeiboProfile.class);
	}

}
