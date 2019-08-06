package me.jastz.common.github.contents;

import me.jastz.common.github.Constants;
import me.jastz.common.github.contents.domain.Content;
import me.jastz.common.github.contents.domain.CreateFileForm;
import me.jastz.common.github.contents.domain.DeleteFileForm;
import me.jastz.common.github.contents.domain.DeleteFileResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

/**
 * @author zhiwen
 */
public class ContentsOperationsImpl implements ContentsOperations {

    private final RestTemplate restTemplate;

    /**
     * @param restTemplate A RestTemplate
     */
    public ContentsOperationsImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Content getReadMe(String user, String repo) {
        String uri = buildUri("repos/{user}/{repo}/readme");
        return restTemplate.getForObject(uri, Content.class, user, repo);
    }

    @Override
    public Content getContent(String user, String repo, String path) {
        String uri = buildUri("repos/{user}/{repo}/contents/{path}");
        return restTemplate.getForObject(uri, Content.class, user, repo, path);
    }


    @Override
    public void createFile(CreateFileForm form, String user, String repo, String path) {
        String uri = buildUri("repos/{user}/{repo}/contents/{path}");
        form.setContent(Base64.getEncoder().encodeToString(form.getContent().getBytes()));
        restTemplate.put(uri, getEntity(form), user, repo, path);
    }

    @Override
    public void deleteFile(DeleteFileForm deleteFileForm, String user, String repo, String path) {
        String uri = buildUri("repos/{user}/{repo}/contents/{path}");
        restTemplate.exchange(uri, HttpMethod.DELETE, getEntity(deleteFileForm), DeleteFileResponse.class, user, repo, path);
    }

    private String buildUri(String uri) {
        return String.format("%s%s", Constants.API_URL_BASE, uri);
    }

    private <T> HttpEntity<T> getEntity(T body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        String userAndPasswordBase64 = System.getenv("userAndPasswordBase64");
        if (userAndPasswordBase64 == null) {
            System.err.println("请在环境变量中设置 userAndPasswordBase64");
        }
        headers.set("Authorization", userAndPasswordBase64);
        HttpEntity<T> entity = new HttpEntity(body, headers);
        return entity;
    }
}
