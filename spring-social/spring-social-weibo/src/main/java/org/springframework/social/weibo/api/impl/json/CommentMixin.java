package org.springframework.social.weibo.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.weibo.api.Status;
import org.springframework.social.weibo.api.WeiboProfile;

import java.util.Date;

/**
 * Annotated mixin to add Jackson annotations to Comment.
 * 
 * @author edva8332
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CommentMixin {
	CommentMixin(
			@JsonProperty("id") long id,
			@JsonProperty("created_at") @JsonDeserialize(using = TimelineDateDeserializer.class) Date createAt,
			@JsonProperty("text") String text,
			@JsonProperty("source") String source) {
	}

	@JsonProperty("mid")
	String mid;
	@JsonProperty("user")
	WeiboProfile user;
	@JsonProperty("status")
	Status status;

}
