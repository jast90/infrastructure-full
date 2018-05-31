package org.springframework.social.weibo.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.weibo.api.*;
import org.springframework.social.weibo.api.impl.json.WeiboModule;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class WeiboTemplate extends AbstractOAuth2ApiBinding implements Weibo {

    private AccountOperations accountOperations;

    private CommentOperations commentOperations;

    private UserOperations userOperations;

    private TimelineOperations timelineOperations;

    private FriendOperations friendOperations;

    private ObjectMapper objectMapper;

    private FavoriteTemplate favouriteOperations;

    private TrendTemplate trendOperations;

    public WeiboTemplate(String accessToken) {
        super(accessToken);
        initialize();
    }

    public WeiboTemplate() {
        initialize();
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        super.configureRestTemplate(restTemplate);
        restTemplate.setErrorHandler(new WeiboErrorHandler());
    }

    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        MappingJackson2HttpMessageConverter converter = super
                .getJsonMessageConverter();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new WeiboModule());
        converter.setObjectMapper(objectMapper);
        return converter;
    }

    @Override
    protected FormHttpMessageConverter getFormMessageConverter() {
        FormHttpMessageConverter messageConverter = super
                .getFormMessageConverter();
        List<HttpMessageConverter<?>> partConverters = new ArrayList<HttpMessageConverter<?>>(
                3);
        partConverters.add(new ByteArrayHttpMessageConverter());
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<MediaType>(2);
        mediaTypes
                .add(new MediaType("text", "plain", Charset.forName("UTF-8")));
        mediaTypes.add(MediaType.ALL);
        stringHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        stringHttpMessageConverter.setWriteAcceptCharset(false);
        partConverters.add(stringHttpMessageConverter);
        partConverters.add(new ResourceHttpMessageConverter());
        messageConverter.setPartConverters(partConverters);
        return messageConverter;
    }

    private void initialize() {
        // Wrap the request factory with a BufferingClientHttpRequestFactory so
        // that the error handler can do repeat reads on the response.getBody()
        super.setRequestFactory(ClientHttpRequestFactorySelector
                .bufferRequests(getRestTemplate().getRequestFactory()));
        initSubApis();
    }

    private void initSubApis() {
        this.userOperations = new UserTemplate(objectMapper, getRestTemplate(),
                isAuthorized());
        this.accountOperations = new AccountTemplate(objectMapper,
                getRestTemplate(), isAuthorized());
        this.timelineOperations = new TimelineTemplate(objectMapper,
                getRestTemplate(), isAuthorized());
        this.friendOperations = new FriendTemplate(objectMapper,
                getRestTemplate(), isAuthorized());
        this.commentOperations = new CommentTemplate(objectMapper,
                getRestTemplate(), isAuthorized());
        this.favouriteOperations = new FavoriteTemplate(objectMapper,
                getRestTemplate(), isAuthorized());
        this.trendOperations = new TrendTemplate(objectMapper,
                getRestTemplate(), isAuthorized());
    }

    @Override
    public UserOperations userOperations() {
        return userOperations;
    }

    @Override
    protected OAuth2Version getOAuth2Version() {
        return OAuth2Version.BEARER_DRAFT_2;
    }

    @Override
    public AccountOperations accountOperations() {
        return accountOperations;
    }

    @Override
    public CommentOperations commentOperations() {
        return commentOperations;
    }

    @Override
    public TimelineOperations timelineOperations() {
        return timelineOperations;
    }

    @Override
    public FriendOperations friendOperations() {
        return friendOperations;
    }

    protected ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    @Override
    public FavoriteOperations favoriteOperations() {
        return favouriteOperations;
    }

    @Override
    public TrendOperations trendOperations() {
        return trendOperations;
    }

}
