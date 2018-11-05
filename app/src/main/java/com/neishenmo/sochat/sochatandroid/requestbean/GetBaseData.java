package com.neishenmo.sochat.sochatandroid.requestbean;

/**
 * Created by Administrator on 2018-05-22.
 */

public class GetBaseData {
    private String token;
    private String telephone;
    private double lat;
    private double lon;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
