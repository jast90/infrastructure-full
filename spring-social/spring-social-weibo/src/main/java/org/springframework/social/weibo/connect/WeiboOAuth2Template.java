package org.springframework.social.weibo.connect;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class WeiboOAuth2Template extends OAuth2Template {

    private static final Log logger = LogFactory
            .getLog(WeiboOAuth2Template.class.getName());

    public WeiboOAuth2Template(String clientId, String clientSecret) {
        super(clientId, clientSecret,
                "https://api.weibo.com/oauth2/authorize",
                "https://api.weibo.com/oauth2/access_token");
        setUseParametersForClientAuthentication(true);
    }

    @Override
    protected RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(
                ClientHttpRequestFactorySelector.getRequestFactory());
        HttpMessageConverter<?> messageConverter = new FormHttpMessageConverter() {

            private final ObjectMapper objectMapper = new ObjectMapper();

            @Override
            public boolean canRead(Class<?> clazz, MediaType mediaType) {
                return true;
            }

            @Override
            public MultiValueMap<String, String> read(
                    Class<? extends MultiValueMap<String, ?>> clazz,
                    HttpInputMessage inputMessage) throws IOException,
                    HttpMessageNotReadableException {

                TypeReference<Map<String, ?>> mapType = new TypeReference<Map<String, ?>>() {
                };
                LinkedHashMap<String, ?> readValue = objectMapper.readValue(
                        inputMessage.getBody(), mapType);
                LinkedMultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
                for (Entry<String, ?> currentEntry : readValue.entrySet()) {
                    result.add(currentEntry.getKey(), currentEntry.getValue()
                            .toString());
                }
                return result;
            }
        };

        restTemplate.setMessageConverters(Collections
                .<HttpMessageConverter<?>>singletonList(messageConverter));
        return restTemplate;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected AccessGrant postForAccessGrant(String accessTokenUrl,
                                             MultiValueMap<String, String> parameters) {
        List<String> params = new ArrayList<>();
        for (String key : parameters.keySet()) {
            params.add(key + "=" + parameters.getFirst(key));
        }

        String url = accessTokenUrl + "?" + params.stream().collect(Collectors.joining("&"));

        if (logger.isDebugEnabled()) {
            logger.debug("url = " + url);
        }
        MultiValueMap<String, String> response = getRestTemplate()
                .postForObject(url, null, MultiValueMap.class);
        String expires = response.getFirst("expires_in");
        String accessToken = response.getFirst("access_token");
        if (logger.isDebugEnabled()) {
            logger.debug("access token value = " + accessToken);
        }
        return new AccessGrant(accessToken, null, null,
                expires != null ? Long.valueOf(expires) : null);
    }

}
