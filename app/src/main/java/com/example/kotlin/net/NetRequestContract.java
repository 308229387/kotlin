package com.example.kotlin.net;


import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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

        void postRequest(JsonParamsBean<String> params);
    }

    interface Model {
        @POST("basic/person/getFugitiveInfo")
        Observable<ObserverBean<PostResultBean>> postRequest(@Body JsonParamsBean<String> params);

        @GET("getTest")
        Observable<ObserverBean<GetResultBean>> getRequest(@Query("key") String query);


    }
}
