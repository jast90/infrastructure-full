package org.springframework.social.weibo.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.weibo.api.Trends.Trend;

import java.util.Date;
import java.util.SortedSet;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class TrendsWrapperMixin {

	@JsonProperty("trends")
	@JsonDeserialize(using = TrendsDeserializer.class)
	SortedSet<Trend> trends;

	@JsonProperty("as_of")
	@JsonDeserialize(using = DateInSecondsDeserializer.class)
	Date asOf;

}
