package models;

import java.util.Date;

public class Address {
    private Integer id;
    private String cityOrTown;
    private String postalCode;
    private String suburbOrDistrict;
    private Date lastUpdated;
    private Type type;
    private AddressLineDetail addressLineDetail;
    private Type provinceOrState;
    private Type country;

    public Address() {
    }

    public Address(Integer id, String cityOrTown, String postalCode, Date lastUpdated,Type type,
                   AddressLineDetail addressLineDetail, Type provinceOrState, Type country, String suburbOrDistrict) {
        this.id = id;
        this.cityOrTown = cityOrTown;
        this.postalCode = postalCode;
        this.lastUpdated = lastUpdated;
        this.type = type;
        this.addressLineDetail = addressLineDetail;
        this.provinceOrState = provinceOrState;
        this.country = country;
        this.suburbOrDistrict = suburbOrDistrict;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public void setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public AddressLineDetail getAddressLineDetail() {
        return addressLineDetail;
    }

    public void setAddressLineDetail(AddressLineDetail addressLineDetail) {
        this.addressLineDetail = addressLineDetail;
    }

    public Type getProvinceOrState() {
        return provinceOrState;
    }

    public void setProvinceOrState(Type provinceOrState) {
        this.provinceOrState = provinceOrState;
    }

    public Type getCountry() {
        return country;
    }

    public void setCountry(Type country) {
        this.country = country;
    }

    public String getSuburbOrDistrict() {
        return suburbOrDistrict;
    }

    public void setSuburbOrDistrict(String suburbOrDistrict) {
        this.suburbOrDistrict = suburbOrDistrict;
    }

    @Override
    public String toString() {
        return  type + " :" + addressLineDetail + " - " + cityOrTown +  " - " + provinceOrState +
                " - " + postalCode + " - " + country ;
    }
}
