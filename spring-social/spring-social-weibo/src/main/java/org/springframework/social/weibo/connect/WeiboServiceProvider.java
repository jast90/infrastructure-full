package org.springframework.social.weibo.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.weibo.api.Weibo;
import org.springframework.social.weibo.api.impl.WeiboTemplate;

public final class WeiboServiceProvider extends
		AbstractOAuth2ServiceProvider<Weibo> {

	public WeiboServiceProvider(String consumerKey, String consumerSecret) {
		super(new WeiboOAuth2Template(consumerKey, consumerSecret));
	}

	@Override
	public Weibo getApi(String accessToken) {
		return new WeiboTemplate(accessToken);
	}

}