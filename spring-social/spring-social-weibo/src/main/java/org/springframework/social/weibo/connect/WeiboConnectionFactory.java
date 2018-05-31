package org.springframework.social.weibo.connect;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.weibo.api.Weibo;

import java.util.Date;

public class WeiboConnectionFactory extends OAuth2ConnectionFactory<Weibo> {

	public WeiboConnectionFactory(String consumerKey, String consumerSecret) {
		super("weibo", new WeiboServiceProvider(consumerKey, consumerSecret),
				new WeiboAdapter());
	}

	@Override
	public Connection<Weibo> createConnection(ConnectionData data) {
		Connection<Weibo> result = null;
		if (data.getExpireTime() == null
				|| new Date(data.getExpireTime()).after(new Date())) {
			result = super.createConnection(data);
		}
		return result;
	}

}
