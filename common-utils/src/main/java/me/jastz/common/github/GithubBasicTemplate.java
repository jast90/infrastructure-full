package me.jastz.common.github;

import me.jastz.common.github.contents.ContentsOperations;
import me.jastz.common.github.contents.ContentsOperationsImpl;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhiwen
 */
public class GithubBasicTemplate implements GitHubOperations {
    private RestTemplate restTemplate;

    public GithubBasicTemplate() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public ContentsOperations contentsOperations() {
        return new ContentsOperationsImpl(restTemplate);
    }
}
