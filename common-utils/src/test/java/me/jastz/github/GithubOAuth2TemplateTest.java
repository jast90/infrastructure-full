package me.jastz.github;

import me.jastz.common.github.GithubBasicTemplate;
import me.jastz.common.github.contents.domain.Content;
import me.jastz.common.github.contents.domain.CreateFileForm;
import me.jastz.common.github.contents.domain.DeleteFileForm;
import me.jastz.common.json.JsonUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhiwen
 */
public class GithubOAuth2TemplateTest {
    private GithubBasicTemplate githubOAuth2Template;
    private String user;
    private String repo;

    @Before
    public void setUp() {
        githubOAuth2Template = new GithubBasicTemplate();
        user = "jast90";
        repo = "common-utils";
    }

    @Test
    public void getReadMe() {
        Content readme = githubOAuth2Template.contentsOperations().getReadMe(user, repo);
        System.out.println(JsonUtil.objectToPrettyJson(readme));
    }

    @Test
    public void createFile() {
        CreateFileForm createFileForm = new CreateFileForm("通过Java代码创建文件", "通过Java代码创建文件");
        githubOAuth2Template.contentsOperations().createFile(createFileForm, user, repo, "createFile2.md");
    }

    @Test
    public void deleteFile() {
        String path = "test.md";
        Content content = githubOAuth2Template.contentsOperations().getContent(user, repo, path);
        System.out.println(JsonUtil.objectToPrettyJson(content));
        DeleteFileForm deleteFileForm = new DeleteFileForm("通过Java代码删除文件", content.getSha());
        githubOAuth2Template.contentsOperations().deleteFile(deleteFileForm, user, repo, path);
    }
}
