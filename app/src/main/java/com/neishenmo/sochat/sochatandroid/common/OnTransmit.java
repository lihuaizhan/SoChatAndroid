package com.neishenmo.sochat.sochatandroid.common;

/**
 * Created by Administrator on 2018-04-25.
 */
//接口回调传递数据
public interface OnTransmit<T> {
    //传递请求成功的数据
    public void onSuccess(T t);

    //传递请求错误信息
    public void onFailure(Throwable throwable);
}
