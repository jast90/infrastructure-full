package cn.jastz.post.client;

import cn.jastz.post.form.PostAddForm;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhiwen
 */
@FeignClient("post")
public interface PostClient {
    @PostMapping("/post")
    BaseResult addPost(@RequestBody PostAddForm postAddForm);
}
