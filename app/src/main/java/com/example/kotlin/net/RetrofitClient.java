package com.example.kotlin.net;

import android.util.Log;

import com.orhanobut.hawk.Hawk;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by 黄振伟
 * 构造Retrofit;
 */

public class RetrofitClient {
    private static volatile RetrofitClient mInstance;
    private final Retrofit retrofit;

    private RetrofitClient() {
        retrofit = buildRetrofit();
    }

    //   页面崩会出现无token的问题，如果没有，就判断添加
    public Retrofit getRetrofit() {
//        if (UnifiedHeadersService.getInstance().getToken() == null && Hawk.contains("token")) {
//            UnifiedHeadersService.getInstance().removeToken();
//            UnifiedHeadersService.getInstance().addHeader("token", Hawk.get("token"));
//        }
        return retrofit;
    }

    //登录页不需要
    public Retrofit getNoInfoRetrofit() {
        return retrofit;
    }

    public static RetrofitClient getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitClient.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitClient();
                }
            }
        }
        return mInstance;
    }

    private Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.getBaseUrl())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(buildOkHttpClient())
                .build();
    }

    /**
     * 配置请求信息返回信息的log
     *
     * @return 返回配置的okhttp
     */
    public OkHttpClient buildOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> Log.e("NetLogInfo", message));
//        if (EnvironmentConfig.PRODUCTION_ENVIRONMENT) {
//            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
//        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(30000, TimeUnit.MILLISECONDS)
                .readTimeout(30000, TimeUnit.MILLISECONDS)
                .writeTimeout(30000, TimeUnit.MILLISECONDS)
                .addInterceptor(chain -> {
                    Request newRequest = chain.request().newBuilder()
//                            .headers(UnifiedHeadersService.getInstance().getHeaders())//添加头信息
                            .build();
                    return chain.proceed(newRequest);
                })
                .addNetworkInterceptor(logging);
        return builder.build();
    }
}
