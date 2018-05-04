package com.neishenmo.sochat.sochatandroid.requestbean;

/**
 * Created by Administrator on 2018\5\2 0002.
 */

public class HomeRequst {
    private String token;
    private String lon;
    private String lat;
    private String simpleAddress;
    private String pageNo;

    public HomeRequst(String token, String lon, String lat, String simpleAddress) {
        this.token = token;
        this.lon = lon;
        this.lat = lat;
        this.simpleAddress = simpleAddress;
    }

    public HomeRequst(String token, String lon, String lat, String simpleAddress, String pageNo) {
        this.token = token;
        this.lon = lon;
        this.lat = lat;
        this.simpleAddress = simpleAddress;
        this.pageNo = pageNo;
    }

    public String getToken() {

        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getSimpleAddress() {
        return simpleAddress;
    }

    public void setSimpleAddress(String simpleAddress) {
        this.simpleAddress = simpleAddress;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }
}
