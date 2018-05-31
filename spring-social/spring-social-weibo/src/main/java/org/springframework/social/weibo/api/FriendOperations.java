package org.springframework.social.weibo.api;

import java.util.List;

public interface FriendOperations {

	WeiboProfile createFriend(long uid);

	WeiboProfile deleteFriend(long uid);

	List<WeiboProfile> getActiveFollowers(long uid);

	List<WeiboProfile> getActiveFollowers(long uid, int pageSize);

	CursoredList<WeiboProfile> getBilateralFriends(long uid);

	CursoredList<WeiboProfile> getBilateralFriends(long uid, int pageSize,
			int pageNumber);

	CursoredList<WeiboProfile> getCommonFriends(long user1Uid, long user2Uid);

	CursoredList<WeiboProfile> getCommonFriends(long user1Uid, long user2Uid,
			int pageSize, int pageNumber);

	CursoredList<WeiboProfile> getFollowers(long uid);

	CursoredList<WeiboProfile> getFollowers(long uid, int pageSize,
			int pageNumber);

	CursoredList<WeiboProfile> getFriends(long uid);

	CursoredList<WeiboProfile> getFriends(long uid, int pageSize, int pageNumber);

}
