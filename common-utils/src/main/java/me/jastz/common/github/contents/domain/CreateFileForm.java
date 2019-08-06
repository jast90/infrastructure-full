package me.jastz.common.github.contents.domain;

import java.io.Serializable;

/**
 * @author zhiwen
 */
public class CreateFileForm implements Serializable {
    private String message;
    private String content;


    public CreateFileForm(String message, String content) {
        this.message = message;
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
