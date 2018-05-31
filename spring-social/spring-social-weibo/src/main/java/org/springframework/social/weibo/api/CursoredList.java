package org.springframework.social.weibo.api;

import java.util.LinkedList;

public class CursoredList<E> extends LinkedList<E> {

	private static final long serialVersionUID = 1L;

	private long previousCursor;
	private long nextCursor;
	private int totalNumber;

	public long getPreviousCursor() {
		return previousCursor;
	}

	public void setPreviousCursor(long previousCursor) {
		this.previousCursor = previousCursor;
	}

	public long getNextCursor() {
		return nextCursor;
	}

	public void setNextCursor(long nextCursor) {
		this.nextCursor = nextCursor;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

}
