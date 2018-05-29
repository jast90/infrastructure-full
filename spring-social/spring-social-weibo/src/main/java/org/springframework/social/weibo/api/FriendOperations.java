/*
 * Copyright 2011 France Telecom R&D Beijing Co., Ltd 北京法国电信研发中心有限公司
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
