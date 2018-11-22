package cn.jastz.express.entity.form;

import org.springframework.data.geo.Point;

/**
 * @author zhiwen
 */
public class AccountExpressQueryLocationForm {
    /**
     * 经度
     */
    private double longitude;
    /**
     * 纬度
     */
    private double latitude;

    public AccountExpressQueryLocationForm(double latitude, double longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
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

    public Point getPoint() {
        return new Point(getLongitude(), getLatitude());
    }
}
