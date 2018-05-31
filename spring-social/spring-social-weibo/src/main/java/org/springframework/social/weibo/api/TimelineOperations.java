package org.springframework.social.weibo.api;

import org.springframework.core.io.Resource;

import java.util.List;

public interface TimelineOperations {

	Status deleteStatus(long id);

	CursoredList<Status> getBilateralTimeline();

	CursoredList<Status> getBilateralTimeline(int pageSize, int pageNumber);

	CursoredList<Status> getBilateralTimeline(int pageSize, int pageNumber,
			boolean onlyApplicationStatus);

	CursoredList<Status> getBilateralTimeline(long sinceId, long maxId,
			int pageSize, int pageNumber, boolean onlyApplicationStatus,
			StatusContentType statusContentType);

	List<Status> getDailyHotComments();

	List<Status> getDailyHotComments(int pageSize, boolean onlyApplicationStatus);

	List<Status> getDailyHotRepost();

	List<Status> getDailyHotRepost(int pageSize, boolean onlyApplicationStatus);

	CursoredList<Status> getFriendsTimeline();

	CursoredList<Status> getFriendsTimeline(int pageSize, int pageNumber);

	CursoredList<Status> getFriendsTimeline(int pageSize, int pageNumber,
			boolean onlyApplicationStatus);

	CursoredList<Status> getFriendsTimeline(long sinceId, long maxId,
			int pageSize, int pageNumber, boolean onlyApplicationStatus,
			StatusContentType statusContentType);

	CursoredList<Status> getHomeTimeline();

	CursoredList<Status> getHomeTimeline(int pageSize, int pageNumber);

	CursoredList<Status> getHomeTimeline(int pageSize, int pageNumber,
			boolean onlyApplicationStatus);

	CursoredList<Status> getHomeTimeline(long sinceId, long maxId,
			int pageSize, int pageNumber, boolean onlyApplicationStatus,
			StatusContentType statusContentType);

	CursoredList<Status> getMentions();

	CursoredList<Status> getMentions(int pageSize, int pageNumber);

	CursoredList<Status> getMentions(long sinceId, long maxId, int pageSize,
			int pageNumber, AuthorFilterType authorFilterType,
			SourceFilterType sourceFilterType, boolean createdInWeibo);

	CursoredList<Status> getPublicTimeline();

	CursoredList<Status> getPublicTimeline(int pageSize, int pageNumber);

	CursoredList<Status> getPublicTimeline(int pageSize, int pageNumber,
			boolean onlyApplicationStatus);

	CursoredList<Status> getRepostByMe();

	CursoredList<Status> getRepostByMe(int pageSize, int pageNumber);

	CursoredList<Status> getRepostByMe(long sinceId, long maxId, int pageSize,
			int pageNumber);

	CursoredList<Status> getRepostTimeline(long id);

	CursoredList<Status> getRepostTimeline(long id, int pageSize, int pageNumber);

	CursoredList<Status> getRepostTimeline(long id, long sinceId, long maxId,
			int pageSize, int pageNumber, AuthorFilterType authorFilterType);

	Status getStatus(long id);

	CursoredList<Status> getUserTimeline(long uid);

	CursoredList<Status> getUserTimeline(long uid, int pageSize, int pageNumber);

	CursoredList<Status> getUserTimeline(long uid, int pageSize,
			int pageNumber, boolean onlyApplicationStatus);

	CursoredList<Status> getUserTimeline(long uid, long sinceId, long maxId,
			int pageSize, int pageNumber, boolean onlyApplicationStatus,
			StatusContentType statusContentType);

	List<Status> getWeeklyHotComments();

	List<Status> getWeeklyHotComments(int pageSize,
			boolean onlyApplicationStatus);

	List<Status> getWeeklyHotRepost();

	List<Status> getWeeklyHotRepost(int pageSize, boolean onlyApplicationStatus);

	Status repostStatus(long id, String message);

	Status updateStatus(String message);

	Status updateStatus(String message, float latitude, float longitude);

	Status updateStatus(String message, Resource media);

	Status updateStatus(String message, Resource media, float latitude,
			float longitude);

}
