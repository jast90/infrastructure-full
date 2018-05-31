package org.springframework.social.weibo.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;



public class DateInSecondsDeserializer extends JsonDeserializer<Date> {

	private static final int MILLISECONDS = 1000;

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new Date(jp.getLongValue() * MILLISECONDS);
	}

}
