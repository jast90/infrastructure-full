package org.springframework.social.weibo.api;

public interface UserOperations {

	WeiboProfile getUserProfileById(long Uid);

	WeiboProfile getUserProfileByScreenName(String screenName);

	WeiboProfile getUserProfileByDomainName(String domainName);

}