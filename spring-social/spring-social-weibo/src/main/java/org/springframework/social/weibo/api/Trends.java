package org.springframework.social.weibo.api;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Trends {

	public static class Trend {
		private String name;
		private String query;
		private long amount;
		private long delta;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the query
		 */
		public String getQuery() {
			return query;
		}

		/**
		 * @param query
		 *            the query to set
		 */
		public void setQuery(String query) {
			this.query = query;
		}

		/**
		 * @return the amount
		 */
		public long getAmount() {
			return amount;
		}

		/**
		 * @param amount
		 *            the amount to set
		 */
		public void setAmount(long amount) {
			this.amount = amount;
		}

		/**
		 * @return the delta
		 */
		public long getDelta() {
			return delta;
		}

		/**
		 * @param delta
		 *            the delta to set
		 */
		public void setDelta(long delta) {
			this.delta = delta;
		}
	}

	private List<Trend> trends = new LinkedList<Trends.Trend>();
	private Date date;

	/**
	 * @return the trends
	 */
	public List<Trend> getTrends() {
		return trends;
	}

	/**
	 * @param trends
	 *            the trends to set
	 */
	public void setTrends(List<Trend> trends) {
		this.trends = trends;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
