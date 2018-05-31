package org.springframework.social.weibo.api;

import java.util.List;

public interface TrendOperations {

	long follow(String trendName);

	TrendsWrapper getDailyTrends();

	TrendsWrapper getDailyTrends(boolean onlyApplicationData);

	List<UserTrend> getTrends(long userId);

	List<UserTrend> getTrends(long userId, int pageSize, int pageNumber);

	FollowedTrend isFollowed(String trendName);

	TrendsWrapper getHourlyTrends();

	TrendsWrapper getHourlyTrends(boolean onlyApplicationData);

	TrendsWrapper getWeeklyTrends();

	TrendsWrapper getWeeklyTrends(boolean onlyApplicationData);

	boolean unfollow(long trendId);

}
