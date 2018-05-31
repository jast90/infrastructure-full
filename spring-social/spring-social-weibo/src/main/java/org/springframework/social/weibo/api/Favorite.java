package org.springframework.social.weibo.api;

import java.util.Date;
import java.util.List;

public class Favorite {

	public static class Tag {
		private long id;
		private String value;
		private int count;

		/**
		 * @return the id
		 */
		public long getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(long id) {
			this.id = id;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * @return the count
		 */
		public int getCount() {
			return count;
		}

		/**
		 * @param count
		 *            the count to set
		 */
		public void setCount(int count) {
			this.count = count;
		}
	}

	private Status status;
	private List<Tag> tags;
	private Date favoritedTime;

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * @return the favoritedTime
	 */
	public Date getFavoritedTime() {
		return favoritedTime;
	}

	/**
	 * @param favoritedTime
	 *            the favoritedTime to set
	 */
	public void setFavoritedTime(Date favoritedTime) {
		this.favoritedTime = favoritedTime;
	}

}
