package com.hyphenate.easeui.utils;

import org.apache.http.NameValuePair;

/**
 * Created by Administrator on 2018/1/2.
 */

public class PostWordModel implements NameValuePair {
    public String key;
    public String value;

    public PostWordModel(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getName() {
        return null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PostWordModel{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
