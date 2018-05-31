package org.springframework.social.weibo.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class DateFormatDeserializer extends JsonDeserializer<Date> {

	public DateFormatDeserializer() {
		super();
	}

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		try {
			return new SimpleDateFormat(getDateFormat(), Locale.ENGLISH)
					.parse(jp.getText());
		} catch (ParseException e) {
			return null;
		}
	}

	protected String getDateFormat() {
		return "yyyy-MM-dd HH:mm:ss";
	}

}