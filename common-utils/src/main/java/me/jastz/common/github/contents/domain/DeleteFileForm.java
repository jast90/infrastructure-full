package me.jastz.common.github.contents.domain;

/**
 * @author zhiwen
 */
public class DeleteFileForm {
    private String message;
    private String sha;

    public DeleteFileForm(String message, String sha) {
        this.message = message;
        this.sha = sha;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}
