package me.jastz.common.china.district;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class City {
    /**
     * 地名
     */
    String name;

    /**
     * 驻地
     */
    String address;
    /**
     * 人口
     */
    BigDecimal population;
    /**
     * 面积
     */
    BigDecimal proportion;
    /**
     * 行政区划代码
     */
    String code;
    /**
     * 区号
     */
    String areaCode;
    /**
     * 邮编
     */
    String zip;

    private int id;

    private int parentId;

    List<City> children;

    public City() {
    }

    public City(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public City(String name, String address, BigDecimal population, BigDecimal proportion, String code, String areaCode, String zip) {
        this.name = name;
        this.address = address;
        this.population = population;
        this.proportion = proportion;
        this.code = code;
        this.areaCode = areaCode;
        this.zip = zip;
    }

    public City(String name, String address, BigDecimal population, BigDecimal proportion, String code, String areaCode, String zip, List<City> children) {
        this.name = name;
        this.address = address;
        this.population = population;
        this.proportion = proportion;
        this.code = code;
        this.areaCode = areaCode;
        this.zip = zip;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPopulation() {
        return population;
    }

    public void setPopulation(BigDecimal population) {
        this.population = population;
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<City> getChildren() {
        return children;
    }

    public void setChildren(List<City> children) {
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getId() == city.getId() &&
                getParentId() == city.getParentId() &&
                Objects.equals(getName(), city.getName()) &&
                Objects.equals(getAddress(), city.getAddress()) &&
                Objects.equals(getPopulation(), city.getPopulation()) &&
                Objects.equals(getProportion(), city.getProportion()) &&
                Objects.equals(getCode(), city.getCode()) &&
                Objects.equals(getAreaCode(), city.getAreaCode()) &&
                Objects.equals(getZip(), city.getZip());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getAddress(), getPopulation(), getProportion(), getCode(), getAreaCode(), getZip(), getId(), getParentId());
    }

    @Override
    public String toString() {
        return "{\"_class\":\"City\", " +
                "\"name\":" + (name == null ? "null" : "\"" + name + "\"") + ", " +
                "\"address\":" + (address == null ? "null" : "\"" + address + "\"") + ", " +
                "\"population\":" + (population == null ? "null" : population) + ", " +
                "\"proportion\":" + (proportion == null ? "null" : proportion) + ", " +
                "\"code\":" + (code == null ? "null" : "\"" + code + "\"") + ", " +
                "\"areaCode\":" + (areaCode == null ? "null" : "\"" + areaCode + "\"") + ", " +
                "\"zip\":" + (zip == null ? "null" : "\"" + zip + "\"") + ", " +
                "\"id\":\"" + id + "\"" + ", " +
                "\"parentId\":\"" + parentId + "\"" + ", " +
                "\"children\":" + (children == null ? "null" : Arrays.toString(children.toArray())) +
                "}";
    }
}
