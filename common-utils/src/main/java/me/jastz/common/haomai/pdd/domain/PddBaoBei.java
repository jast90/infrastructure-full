package me.jastz.common.haomai.pdd.domain;

import java.math.BigDecimal;

/**
 * @author zhangzhiwen on 2019/12/6
 **/
public class PddBaoBei {

    private String name;

    private String image;

    private String price;

    /**
     * 佣金
     */
    private String brokerage;

    /**
     * 比率
     */
    private BigDecimal rate;

    /**
     * 销量
     */
    private int salesVolume;

    private String storeName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(String brokerage) {
        this.brokerage = brokerage;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public int getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
