package me.jastz.common.zhihu.topic;

import me.jastz.common.zhihu.topic.vo.TopicsPlazzaListVo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhiwen
 */
public class TopicOperationsImpl implements TopicOperations {

    private RestTemplate restTemplate;

    public TopicOperationsImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public TopicsPlazzaListVo list(String method, int topicId, int offset, String hashId) {
        TopicsPlazzaListVo topicsPlazzaListVo = null;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("method", method);
        map.add("params", String.format("{\"topic_id\":%s,\"offset\":%s,\"hash_id\":\"%s\"}", topicId, offset, hashId));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);

        ResponseEntity<TopicsPlazzaListVo> responseEntity = restTemplate.postForEntity(TopicUrls.TopicsPlazzaListV2Url, request, TopicsPlazzaListVo.class);
        if (responseEntity != null) {
            topicsPlazzaListVo = responseEntity.getBody();
        }
        return topicsPlazzaListVo;
    }
}
