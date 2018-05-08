package com.neishenmo.sochat.sochatandroid.bean;

/**
 * Created by Administrator on 2018-05-08.
 */

public class LiveContent {


    /**
     * amount : 10
     * telephone : 18710291300
     * picture : https://neishenme.oss-cn-beijing.aliyuncs.com/1525310735-9A7C37E4-ACAC-4B00-8484-2D85170E1386.jpg
     */

    private String amount;
    private String telephone;
    private String picture;
    private String simpleAddress;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSimpleAddress() {
        return simpleAddress;
    }

    public void setSimpleAddress(String simpleAddress) {
        this.simpleAddress = simpleAddress;
    }
}
