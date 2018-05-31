package org.springframework.social.weibo.api;

public class FollowedTrend {

	private long trendId;
	private boolean followed;

	/**
	 * @return the trendId
	 */
	public long getTrendId() {
		return trendId;
	}

	/**
	 * @param trendId
	 *            the trendId to set
	 */
	public void setTrendId(long trendId) {
		this.trendId = trendId;
	}

	/**
	 * @return the followed
	 */
	public boolean isFollowed() {
		return followed;
	}

	/**
	 * @param followed
	 *            the followed to set
	 */
	public void setFollowed(boolean followed) {
		this.followed = followed;
	}

}
