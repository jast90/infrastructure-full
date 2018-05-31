package org.springframework.social.weibo.api;

import java.util.Date;
import java.util.SortedSet;

public class TrendsWrapper {

	private SortedSet<Trends> trends;

	private Date asOf;

	/**
	 * @return the trends
	 */
	public SortedSet<Trends> getTrends() {
		return trends;
	}

	/**
	 * @param trends
	 *            the trends to set
	 */
	public void setTrends(SortedSet<Trends> trends) {
		this.trends = trends;
	}

	/**
	 * @return the asOf
	 */
	public Date getAsOf() {
		return asOf;
	}

	/**
	 * @param asOf
	 *            the asOf to set
	 */
	public void setAsOf(Date asOf) {
		this.asOf = asOf;
	}

}
