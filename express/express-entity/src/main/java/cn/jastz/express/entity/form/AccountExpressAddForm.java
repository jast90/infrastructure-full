package cn.jastz.express.entity.form;

import cn.jastz.express.entity.AccountExpress;
import org.springframework.data.geo.Point;

import java.math.BigDecimal;

/**
 * @author zhiwen
 */
public class AccountExpressAddForm {
    /**
     * 经度
     */
    private double longitude;
    /**
     * 纬度
     */
    private double latitude;
    private String fromAddress;
    private String toAddress;
    private String itemDescription;
    private int accountId;

    public AccountExpressAddForm(Point point, String fromAddress, String toAddress, String itemDescription, int accountId) {
        this.latitude = point.getY();
        this.longitude = point.getX();
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.itemDescription = itemDescription;
        this.accountId = accountId;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public AccountExpress to() {
        AccountExpress accountExpress = new AccountExpress();
        accountExpress.setLatitude(new BigDecimal(getLatitude()));
        accountExpress.setLongitude(new BigDecimal(getLongitude()));
        accountExpress.setFromAddress(getFromAddress());
        accountExpress.setToAddress(getToAddress());
        accountExpress.setSenderAccountId(getAccountId());
        accountExpress.setItemDescription(getItemDescription());
        return accountExpress;
    }

    public Point getPoint() {
        return new Point(getLongitude(), getLatitude());
    }
}
