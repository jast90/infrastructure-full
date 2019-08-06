package me.jastz.common.github.contents;


import me.jastz.common.github.contents.domain.Content;
import me.jastz.common.github.contents.domain.CreateFileForm;
import me.jastz.common.github.contents.domain.DeleteFileForm;

/**
 * @author zhiwen
 */
public interface ContentsOperations {

    Content getReadMe(String user, String repo);

    Content getContent(String user, String repo, String path);

    void createFile(CreateFileForm form, String user, String repo, String path);

    void deleteFile(DeleteFileForm deleteFileForm, String user, String repo, String path);
}
