package me.jastz.common.amap.geo.entity;

/**
 * Created by zhiwen on 2017/6/12.
 */

import org.springframework.data.geo.Point;

/**
 {
     "status": "1",
     "info": "OK",
     "infocode": "10000",
     "count": "1",
     "geocodes": [
         {
         "formatted_address": "北京市朝阳区方恒国际中心|A座",
         "province": "北京市",
         "citycode": "010",
         "city": "北京市",
         "district": "朝阳区",
         "township": [ ],
         "neighborhood": {
             "name": [ ],
             "type": [ ]
         },
         "building": {
             "name": [ ],
             "type": [ ]
         },
         "adcode": "110105",
         "street": [ ],
         "number": [ ],
         "location": "116.480724,39.989584",
         "level": "门牌号"
         }
     ]
 }
 */
public class GeoCode {
    private String formatted_address;
    private String province;
    private String citycode;
    private String city;
    private String district;
    private String adcode;
    private String location;
    private String level;

    public Point getLocalPoint(){
        String[] str = getLocation().split(",");
        Point locationPoint = new Point(Double.parseDouble(str[0]),Double.parseDouble(str[1]));
        return locationPoint;
    };

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
