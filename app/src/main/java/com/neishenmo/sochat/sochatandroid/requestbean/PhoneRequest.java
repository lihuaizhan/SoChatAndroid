package com.neishenmo.sochat.sochatandroid.requestbean;

/**
 * Created by Administrator on 2018\4\28 0028.
 */

public class PhoneRequest {
    private String telephone;
    private String pageNo;

    public PhoneRequest(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }
}
