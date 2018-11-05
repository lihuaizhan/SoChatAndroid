package com.neishenmo.sochat.sochatandroid.bean;

/**
 * Created by Administrator on 2018-05-11.
 */

public class ApilyLogin {

    /**
     * code : 200
     * msg : 支付宝授权签名成功
     * data : apiname=com.alipay.account.auth&app_id=2018030502320976&app_name=mc&auth_type=AUTHACCOUNT&biz_type=openservice&method=alipay.open.auth.sdk.code.get&pid=2088921966408214&product_id=APP_FAST_LOGIN&scope=kuaijie&sign_type=RSA&target_id=AL20180511114044443002&sign=iWJwnGtaTs5iiycT4i8CzK72%2FDdd3m3jkfqIiT%2BppwleMzAunEMG6YydzUwJogZxAG6Rkm2u12Gn6hmihUK4YaA3FQHAptPBN7Bms%2F3q63h4sjWUFRBvTru6U9PWyz7sJdPchRj7yPnwrsSO1wSA%2F%2BESSpQgP4S%2FmlWG%2BeT2Km4CypcXHOg64Z5hlU%2F6%2FU10vzyzSxyfCnfHykjAuHhNCkvwT5BUJcFe8pQ74IVDGD%2BcK0XSlPDUp06LaB0w5r0ta1%2ByIb2jS8AFO8M%2FapwlCTaFwVgqupG%2Ba66m5OoN9GC%2BJ72dSY02btTwiPptUidc67BRRi6fNkN%2B%2FbpKkYXzXA%3D%3D
     */

    private int code;
    private String msg;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
