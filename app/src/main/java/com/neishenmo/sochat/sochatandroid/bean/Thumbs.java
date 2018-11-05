package com.neishenmo.sochat.sochatandroid.bean;

/**
 * Created by Administrator on 2018-05-04.
 */

public class Thumbs {
    private String token;
    private String telephone;
    private String amount;

    public Thumbs() {
    }

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Thumbs{" +
                "token='" + token + '\'' +
                ", telephone='" + telephone + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
