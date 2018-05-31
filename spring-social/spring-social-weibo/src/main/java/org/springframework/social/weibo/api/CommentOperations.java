package org.springframework.social.weibo.api;

import java.util.List;

public interface CommentOperations {

	Comment createComment(long id, String comment);

	Comment createComment(long id, String comment,
			boolean commentFromExternalSource);

	Comment deleteComment(long id);

	List<Comment> deleteComments(List<Long> ids);

	CursoredList<Comment> getCommentsByMe();

	CursoredList<Comment> getCommentsByMe(int pageSize, int pageNumber);

	CursoredList<Comment> getCommentsByMe(int pageSize, int pageNumber,
			SourceFilterType sourceFilterType);

	CursoredList<Comment> getCommentsByMe(long sinceId, long maxId,
			int pageSize, int pageNumber, SourceFilterType sourceFilterType);

	CursoredList<Comment> getMentioningComments();

	CursoredList<Comment> getMentioningComments(int pageSize, int pageNumber);

	CursoredList<Comment> getMentioningComments(int pageSize, int pageNumber,
			AuthorFilterType authorFilterType, SourceFilterType sourceFilterType);

	CursoredList<Comment> getMentioningComments(long sinceId, long maxId,
			int pageSize, int pageNumber, AuthorFilterType authorFilterType,
			SourceFilterType sourceFilterType);

	CursoredList<Comment> getCommentsOnStatus(long id);

	CursoredList<Comment> getCommentsOnStatus(long id, int pageSize,
			int pageNumber);

	CursoredList<Comment> getCommentsOnStatus(long id, int pageSize,
			int pageNumber, AuthorFilterType authorFilterType);

	CursoredList<Comment> getCommentsOnStatus(long id, long sinceId,
			long maxId, int pageSize, int pageNumber,
			AuthorFilterType authorFilterType);

	/**
	 * @deprecated This API seems buggy, no result is returned
	 * @param ids
	 * @return
	 */
	@Deprecated
	List<Comment> getCommentsOnStatuses(List<Long> ids);

	CursoredList<Comment> getCommentsTimeline();

	CursoredList<Comment> getCommentsTimeline(int pageSize, int pageNumber);

	CursoredList<Comment> getCommentsTimeline(long sinceId, long maxId,
			int pageSize, int pageNumber);

	CursoredList<Comment> getCommentsToMe();

	CursoredList<Comment> getCommentsToMe(int pageSize, int pageNumber);

	CursoredList<Comment> getCommentsToMe(int pageSize, int pageNumber,
			AuthorFilterType authorFilterType, SourceFilterType sourceFilterType);

	CursoredList<Comment> getCommentsToMe(long sinceId, long maxId,
			int pageSize, int pageNumber, AuthorFilterType authorFilterType,
			SourceFilterType sourceFilterType);

	Comment replyComment(long commentId, long statusId, String comment);

	Comment replyComment(long commentId, long statusId, String comment,
			boolean withoutMention, boolean commentFromExternalSource);

}
