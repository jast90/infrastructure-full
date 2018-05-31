package org.springframework.social.weibo.api;

import org.springframework.social.weibo.api.Favorite.Tag;

import java.util.List;

public interface FavoriteOperations {

	Favorite createFavorite(long id);

	Favorite deleteFavorite(long id);

	boolean deleteFavorites(List<Long> ids);

	Favorite getFavorite(long id);

	CursoredList<Favorite> getFavorites();

	CursoredList<Favorite> getFavorites(int pageSize, int pageNumber);

	CursoredList<Favorite> getFavoritesByTag(long tagId);

	CursoredList<Favorite> getFavoritesByTag(long tagId, int pageSize,
			int pageNumber);

	CursoredList<Tag> getTags();

	CursoredList<Tag> getTags(int pageSize, int pageNumber);

	Favorite updateTags(long id, List<String> tags);

}
