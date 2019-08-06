package me.jastz.common.zhihu.topic;

import me.jastz.common.zhihu.topic.vo.TopicsPlazzaListVo;

/**
 * @author zhiwen
 */
public interface TopicOperations {
    TopicsPlazzaListVo list(String method, int topicId, int offset, String hashId);
}
