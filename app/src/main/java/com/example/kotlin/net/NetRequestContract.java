package com.example.kotlin.net;


import com.example.kotlin.activity.NetRequestActivity;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 2022/5/26
 * Describe ：
 */
public interface NetRequestContract {
    interface View extends IBaseView {
        //        void updateUI(List<ItemProductList> bean);
        void updateGetUI(GetResultBean bean);

        void updatePostUI(PostResultBean bean);


    }

    interface Presenter extends IBasePresenter {
        void getRequest(String params);

        void postRequest(JsonParamsBean<NetRequestActivity.Data> params);
    }

    interface Model {

        @Headers({"YYPZ:%7B%22credential%22%3A%7B%22head%22%3A%7B%22duration%22%3A%7B%22startTime%22%3A1687158753334%2C%22endTime%22%3A1687417953334%7D%2C%22credType%22%3A%222%22%2C%22version%22%3A%221.0%22%2C%22token%22%3A%7B%22tokenId%22%3A%22d555accb86784ab8a931d38d29de8581%22%2C%22orgId%22%3A%22010000000000%22%7D%7D%2C%22load%22%3A%7B%22appInfo%22%3A%7B%22appId%22%3A%22010000000000-2-0100-5dc9a4cc1e9d486aad892214bcd03e3d%22%2C%22networkAreaCode%22%3A%222%22%2C%22orgId%22%3A%22010000000000%22%2C%22version%22%3A%221%22%7D%7D%2C%22serverSign%22%3A%7B%22signature%22%3A%22%22%2C%22sn%22%3A%22%22%2C%22alg%22%3A%22SM3%2BSM2%22%7D%7D%7D","requestType:service","secretKey:c4e7ec5879c9cb01e9bb5b4284b74185","User-Agent:android","userAgent:android","version:1.1.4","token: ","phoneVersion:10","YHPZ:%7B%22credential%22%3A%7B%22head%22%3A%7B%22duration%22%3A%7B%22startTime%22%3A1685668186834%2C%22endTime%22%3A1694308186834%7D%2C%22credType%22%3A%221%22%2C%22version%22%3A%221.0%22%2C%22token%22%3A%7B%22tokenId%22%3A%22105bd0493907470a9c9f7932372192df%22%2C%22orgId%22%3A%22010000000000%22%7D%7D%2C%22load%22%3A%7B%22userInfo%22%3A%7B%22jh%22%3A%22110105197912260011%22%2C%22orgId%22%3A%22010000000000%22%2C%22sfzh%22%3A%22110105197912260011%22%2C%22userId%22%3A%221b02931a-4c7f-4aad-9336-b4a7be269bbf%22%2C%22xm%22%3A%22%E6%AF%9B%E5%B4%9F%22%7D%7D%2C%22serverSign%22%3A%7B%22signature%22%3A%22%22%2C%22sn%22%3A%22%22%2C%22alg%22%3A%22SM3%2BSM2%22%7D%7D%7D","phoneModel:LIO-AN00","osVersion:29","XXBS:1","imei:09ac81722eea9573","serviceID:57648d91f8424e1186ad0c391f1a4564"})
        @POST("route/all/")
        Observable<ObserverBean<PostResultBean>> postRequest(@Body JsonParamsBean<NetRequestActivity.Data> params);

        @GET("getTest")
        Observable<ObserverBean<GetResultBean>> getRequest(@Query("key") String query);


    }
}
