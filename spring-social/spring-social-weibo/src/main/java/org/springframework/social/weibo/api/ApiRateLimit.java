package org.springframework.social.weibo.api;

public class ApiRateLimit {

	private String api;
	private int limit;
	private LimitTimeUnit limitTimeUnit;
	private int remainingHits;

	/**
	 * @return the api
	 */
	public String getApi() {
		return api;
	}

	/**
	 * @param api
	 *            the api to set
	 */
	public void setApi(String api) {
		this.api = api;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
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
	 * @return the remainingHits
	 */
	public int getRemainingHits() {
		return remainingHits;
	}

	/**
	 * @param remainingHits
	 *            the remainingHits to set
	 */
	public void setRemainingHits(int remainingHits) {
		this.remainingHits = remainingHits;
	}

}
