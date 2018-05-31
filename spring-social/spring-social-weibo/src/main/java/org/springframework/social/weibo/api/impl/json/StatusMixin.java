package org.springframework.social.weibo.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.weibo.api.Status;
import org.springframework.social.weibo.api.WeiboProfile;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class StatusMixin {

	StatusMixin(
			@JsonProperty("id") Long id,
			@JsonProperty("created_at") @JsonDeserialize(using = TimelineDateDeserializer.class) Date createAt,
			@JsonProperty("text") String text,
			@JsonProperty("source") String source,
			@JsonProperty("favorited") boolean favorited,
			@JsonProperty("truncated") boolean truncated,
			@JsonProperty("reposts_count") int repostsCount,
			@JsonProperty("comments_count") int commentsCount) {
	}

	@JsonProperty("in_reply_to_status_id")
	String inReplyToStatusId;
	@JsonProperty("in_reply_to_user_id")
	String inReplyToUserId;
	@JsonProperty("in_reply_to_screen_name")
	String inReplyToScreenName;
	@JsonProperty("mid")
	String mid;
	@JsonProperty("user")
	WeiboProfile user;
	@JsonProperty("retweeted_status")
	Status originalStatus;

}
