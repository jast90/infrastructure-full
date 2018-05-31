package org.springframework.social.weibo.api;

public interface AccountOperations {

	long getUid();

	RateLimitStatus getRateLimitStatus();

}
