
package org.springframework.social.weibo.api;

import java.util.Date;
import java.util.List;

public class RateLimitStatus {

	private int ipLimit;
	private LimitTimeUnit limitTimeUnit;
	private int remainingIpHits;
	private int remainingUserHits;
	private Date resetTime;
	private int resetTimeInSeconds;
	private int userLimit;
	private List<ApiRateLimit> apiRateLimits;

	/**
	 * @return the ipLimit
	 */
	public int getIpLimit() {
		return ipLimit;
	}

	/**
	 * @param ipLimit
	 *            the ipLimit to set
	 */
	public void setIpLimit(int ipLimit) {
		this.ipLimit = ipLimit;
	}

	/**
	 * @return the limitTimeUnit
	 */
	public LimitTimeUnit getLimitTimeUnit() {
		return limitTimeUnit;
	}

	/**
	 * @param limitTimeUnit
	 *            the limitTimeUnit to set
	 */
	public void setLimitTimeUnit(LimitTimeUnit limitTimeUnit) {
		this.limitTimeUnit = limitTimeUnit;
	}

	/**
	 * @return the remainingIpHits
	 */
	public int getRemainingIpHits() {
		return remainingIpHits;
	}

	/**
	 * @param remainingIpHits
	 *            the remainingIpHits to set
	 */
	public void setRemainingIpHits(int remainingIpHits) {
		this.remainingIpHits = remainingIpHits;
	}

	/**
	 * @return the remainingUserHits
	 */
	public int getRemainingUserHits() {
		return remainingUserHits;
	}

	/**
	 * @param remainingUserHits
	 *            the remainingUserHits to set
	 */
	public void setRemainingUserHits(int remainingUserHits) {
		this.remainingUserHits = remainingUserHits;
	}

	/**
	 * @return the resetTime
	 */
	public Date getResetTime() {
		return resetTime;
	}

	/**
	 * @param resetTime
	 *            the resetTime to set
	 */
	public void setResetTime(Date resetTime) {
		this.resetTime = resetTime;
	}

	/**
	 * @return the resetTimeInSeconds
	 */
	public int getResetTimeInSeconds() {
		return resetTimeInSeconds;
	}

	/**
	 * @param resetTimeInSeconds
	 *            the resetTimeInSeconds to set
	 */
	public void setResetTimeInSeconds(int resetTimeInSeconds) {
		this.resetTimeInSeconds = resetTimeInSeconds;
	}

	/**
	 * @return the userLimit
	 */
	public int getUserLimit() {
		return userLimit;
	}

	/**
	 * @param userLimit
	 *            the userLimit to set
	 */
	public void setUserLimit(int userLimit) {
		this.userLimit = userLimit;
	}

	/**
	 * @return the apiRateLimits
	 */
	public List<ApiRateLimit> getApiRateLimits() {
		return apiRateLimits;
	}

	/**
	 * @param apiRateLimits
	 *            the apiRateLimits to set
	 */
	public void setApiRateLimits(List<ApiRateLimit> apiRateLimits) {
		this.apiRateLimits = apiRateLimits;
	}

}
