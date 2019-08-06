package me.jastz.common.stackoverflow;

/**
 * @author zhiwen
 */
public enum SofUrl {
    users("https://stackoverflow.com/users?page={page}&tab={tab}&filter={filter}");
    private String url;

    SofUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
