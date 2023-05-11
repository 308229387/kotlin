package com.example.kotlin.net;


import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 黄振伟
 * 2022/5/21
 * Describe ：
 */
public class ProductListPresenter implements ProductListContract.Presenter {

    private ProductListContract.View mView;
    private final ProductListContract.Model model;
    private final CompositeDisposable mDisposable;
    public ProductListPresenter(ProductListContract.View mView) {
        this.mView = mView;
        mDisposable = new CompositeDisposable();
        model = RetrofitClient.getInstance().getRetrofit().create(ProductListContract.Model.class);
    }

    @Override
    public void getRequest(String params) {
        model.getRequest(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<GetResultBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onReply(GetResultBean reply) {
                        if (mView != null) {
                            mView.updateGetUI(reply);
                        }
                    }

                    @Override
                    public void onFailure(String errorMsg) {
                        if (mView != null) {
                            mView.onError(errorMsg);
                        }
                    }
                });
    }

    @Override
    public void postRequest(JsonParamsBean params) {
        model.postRequest(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<PostResultBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onReply(PostResultBean reply) {
                        if (mView != null) {
                            mView.updatePostUI(reply);
                        }
                    }

                    @Override
                    public void onFailure(String errorMsg) {
                        if (mView != null) {
                            mView.onError(errorMsg);
                        }
                    }
                });
    }

    @Override
    public void onDestroyPresenter() {
        if (mDisposable != null && mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
        mView = null;
    }
}
