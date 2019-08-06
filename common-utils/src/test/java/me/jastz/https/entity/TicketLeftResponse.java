package me.jastz.https.entity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhiwen on 2016/12/27.
 */
public class TicketLeftResponse {
    private String validateMessagesShowId;
    private boolean status;
    private int httpstatus;
    private String[] messages;
    private String[] validateMessages;
    private List<Data> data;

    public String getValidateMessagesShowId() {
        return validateMessagesShowId;
    }

    public void setValidateMessagesShowId(String validateMessagesShowId) {
        this.validateMessagesShowId = validateMessagesShowId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getHttpstatus() {
        return httpstatus;
    }

    public void setHttpstatus(int httpstatus) {
        this.httpstatus = httpstatus;
    }

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    public String[] getValidateMessages() {
        return validateMessages;
    }

    public void setValidateMessages(String[] validateMessages) {
        this.validateMessages = validateMessages;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TicketLeftResponse{" +
                "validateMessagesShowId='" + validateMessagesShowId + '\'' +
                ", status=" + status +
                ", httpstatus=" + httpstatus +
                ", messages=" + Arrays.toString(messages) +
                ", validateMessages=" + Arrays.toString(validateMessages) +
                ", data=" + data +
                '}';
    }
}
