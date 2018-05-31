package org.springframework.social.weibo.api.impl.json;


import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.social.weibo.api.*;
import org.springframework.social.weibo.api.Favorite.Tag;
import org.springframework.social.weibo.api.impl.json.FavoriteMixin.TagMixin;

public class WeiboModule extends SimpleModule {

	public WeiboModule() {
		super("WeiboModule");
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(WeiboProfile.class, WeiboProfileMixin.class);
		context.setMixInAnnotations(Status.class, StatusMixin.class);
		context.setMixInAnnotations(Comment.class, CommentMixin.class);
		context.setMixInAnnotations(ApiRateLimit.class, ApiRateLimitMixin.class);
		context.setMixInAnnotations(RateLimitStatus.class,
				RateLimitStatusMixin.class);
		context.setMixInAnnotations(Favorite.class, FavoriteMixin.class);
		context.setMixInAnnotations(Tag.class, TagMixin.class);
		context.setMixInAnnotations(UserTrend.class, UserTrendMixin.class);
		context.setMixInAnnotations(FollowedTrend.class,
				FollowedTrendMixin.class);
		context.setMixInAnnotations(TrendsWrapper.class,
				TrendsWrapperMixin.class);
	}

}
