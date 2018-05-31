package org.springframework.social.weibo.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.weibo.api.Status;

import java.util.Date;

/**
 * Annotated mixin to add Jackson annotations to Favorite.
 * 
 * @author edva8332
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class FavoriteMixin {

	@JsonIgnoreProperties(ignoreUnknown = true)
	abstract static class TagMixin {
		long id;
		@JsonProperty("tag")
		String value;
		int count;
	}

	@JsonProperty("status")
	Status status;
	@JsonProperty("favorited_time")
	@JsonDeserialize(using = TimelineDateDeserializer.class)
	Date favoritedTime;
}
