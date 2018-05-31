package org.springframework.social.weibo.api.impl.json;

class TimelineDateDeserializer extends DateFormatDeserializer {

	private static final String TIMELINE_DATE_FORMAT = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";

	@Override
	protected String getDateFormat() {
		return TIMELINE_DATE_FORMAT;
	}

}
