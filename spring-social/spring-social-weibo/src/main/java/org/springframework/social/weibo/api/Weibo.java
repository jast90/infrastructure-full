package org.springframework.social.weibo.api;

public interface Weibo {

	AccountOperations accountOperations();

	CommentOperations commentOperations();

	FriendOperations friendOperations();

	FavoriteOperations favoriteOperations();

	TimelineOperations timelineOperations();

	UserOperations userOperations();

	TrendOperations trendOperations();

}
