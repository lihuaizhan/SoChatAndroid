package com.neishenmo.sochat.sochatandroid.net;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2018-02-26  16:31
 * 封装Retrofit帮助类
 */

public class RetrofitHelper {
    private static OkHttpClient okHttpClient;
    private static ServiceApi serviceApi;


    static {
        initOkHttpClient();
    }

    /**
     * 创建OkHttpClient
     */
    private static void initOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (okHttpClient == null) {
                    //设置拦截器

                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(new Interceptor() {
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request request = chain.request()
                                            .newBuilder()
                                            .addHeader("Content-Type", "application/json; charset=UTF-8")
                                            .addHeader("Accept-Encoding", "gzip, deflate")
                                            .addHeader("Connection", "keep-alive")
                                            .addHeader("Accept", "*/*")
                                            .addHeader("Cookie", "add cookies here")
                                            .build();
                                    return chain.proceed(request);
                                }
                            })
                            //设置连接超时
                            .connectTimeout(60, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }

    /**
     * 定义一个泛型方法
     *
     * @param tClass
     * @param url
     * @param <T>
     * @return
     */
    public static <T> T createAPi(Class<T> tClass, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(tClass);
    }

    /**
     * 初始化ServiceApi
     *
     * @return
     */
    public static ServiceApi getServiceApi() {
        if (serviceApi == null) {
            synchronized (ServiceApi.class) {
                if (serviceApi == null) {
                    serviceApi = createAPi(ServiceApi.class, ConnectorApi.BASE_URL);
                }
            }
        }
        return serviceApi;
    }


}
