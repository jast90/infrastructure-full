package org.springframework.social.weibo.api;

public class UserTrend {

	private long id;
	private String num;
	private String hotword;

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
	 * @return the num
	 */
	public String getNum() {
		return num;
	}

	/**
	 * @param num
	 *            the num to set
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * @return the hotword
	 */
	public String getHotword() {
		return hotword;
	}

	/**
	 * @param hotword
	 *            the hotword to set
	 */
	public void setHotword(String hotword) {
		this.hotword = hotword;
	}

}
