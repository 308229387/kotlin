package com.example.kotlin.net;


import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 黄振伟
 * 2022/5/26
 * Describe ：
 */
public interface ProductListContract {
    interface View extends IBaseView {
        //        void updateUI(List<ItemProductList> bean);
        void updateGetUI(GetResultBean bean);

        void updatePostUI(PostResultBean bean);


    }

    interface Presenter extends IBasePresenter {
        void getRequest(String params);

        void postRequest(JsonParamsBean<String> params);
    }

    interface Model {
        @POST("basic/person/getFugitiveInfo")
        Observable<ObserverBean<PostResultBean>> postRequest(@Body JsonParamsBean<String> params);

        @GET("getTest")
        Observable<ObserverBean<GetResultBean>> getRequest(@Query("key") String query);
    }
}
