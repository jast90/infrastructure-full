package org.springframework.social.weibo.api.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.social.support.URIBuilder;
import org.springframework.social.weibo.api.CursoredList;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.List;

abstract class AbstractWeiboOperations {

	private static final String API_URL_BASE = "https://api.weibo.com/2/";
	// private static final String API_URL_BASE = "http://localhost:9999/2/";
	private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();

	private final boolean isAuthorized;
	protected final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;

	protected AbstractWeiboOperations(ObjectMapper objectMapper,
			RestTemplate restTemplate, boolean isAuthorized) {
		this.objectMapper = objectMapper;
		this.isAuthorized = isAuthorized;
		this.restTemplate = restTemplate;
	}

	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException("weibo");
		}
	}

	protected URI buildUri(String path) {
		return buildUri(path, EMPTY_PARAMETERS);
	}

	protected URI buildUri(String path, String parameterName,
			Object parameterValue) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set(parameterName, parameterValue.toString());
		return buildUri(path, parameters);
	}

	protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
		return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters)
				.build();
	}

	protected URIBuilder uriBuilder(String path) {
		return URIBuilder.fromUri(API_URL_BASE + path);
	}

	protected <T> CursoredList<T> deserializeCursoredList(JsonNode jsonNode,
			final Class<T> elementType, String dataFieldName) {
		CursoredList<T> result = new CursoredList<T>();
		JsonNode previousCursorNode = jsonNode.get("previous_cursor");
		if (previousCursorNode != null) {
			result.setPreviousCursor(previousCursorNode.asLong());
		}
		JsonNode nextCursorNode = jsonNode.get("next_cursor");
		if (nextCursorNode != null) {
			result.setNextCursor(nextCursorNode.asLong());
		}
		result.setTotalNumber(jsonNode.get("total_number").asInt());
		result.addAll(deserializeDataList(jsonNode.get(dataFieldName),
				elementType));
		return result;
	}

	@SuppressWarnings("unchecked")
	protected <T> List<T> deserializeDataList(JsonNode jsonNode,
			final Class<T> elementType) {
		try {
			CollectionType listType = TypeFactory.defaultInstance()
					.constructCollectionType(List.class, elementType);
			return (List<T>) objectMapper.reader(listType).readValue(jsonNode.toString());
		} catch (IOException e) {
			throw new UncategorizedApiException("weibo",
					"Error deserializing data from Weibo: " + e.getMessage(), e);
		}
	}

}
