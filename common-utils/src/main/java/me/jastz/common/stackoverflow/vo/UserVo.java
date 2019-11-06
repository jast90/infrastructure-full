package me.jastz.common.stackoverflow.vo;

/**
 * @author zhiwen
 */
public class UserVo {
    private String url;
    private String name;
    private String location;
    private String reputationScore;
    private Long goldBadges;
    private Long silverBadges;
    private Long bronzeBadges;
    private int page;

    public UserVo() {
    }


    public UserVo(String url, String name, String location, String reputationScore, Long goldBadges, Long silverBadges, Long bronzeBadges) {
        this.url = url;
        this.name = name;
        this.location = location;
        this.reputationScore = reputationScore;
        this.goldBadges = goldBadges;
        this.silverBadges = silverBadges;
        this.bronzeBadges = bronzeBadges;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReputationScore() {
        return reputationScore;
    }

    public void setReputationScore(String reputationScore) {
        this.reputationScore = reputationScore;
    }

    public Long getGoldBadges() {
        return goldBadges;
    }

    public void setGoldBadges(Long goldBadges) {
        this.goldBadges = goldBadges;
    }

    public Long getSilverBadges() {
        return silverBadges;
    }

    public void setSilverBadges(Long silverBadges) {
        this.silverBadges = silverBadges;
    }

    public Long getBronzeBadges() {
        return bronzeBadges;
    }

    public void setBronzeBadges(Long bronzeBadges) {
        this.bronzeBadges = bronzeBadges;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
