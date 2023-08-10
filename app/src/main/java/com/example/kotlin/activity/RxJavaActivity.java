package com.example.kotlin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.kotlin.R;

import org.w3c.dom.Text;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxJavaActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_java_learn_layout);

        rx();
        rx1();
    }

    public void rx(){
        Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                        // 模拟耗时操作，例如网络请求或数据库查询
                        emitter.onNext(Thread.currentThread().getName()); // 发出结果

                        Thread.sleep(4000);
                        String result = "耗时操作的结果";
                        emitter.onNext(result); // 发出结果
                        emitter.onComplete(); // 完成操作
                    }
                })
                .subscribeOn(Schedulers.io()) // 在IO线程执行耗时操作
                .observeOn(AndroidSchedulers.mainThread()) // 在主线程处理结果
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // 订阅时的操作
                    }

                    @Override
                    public void onNext(String result) {
                        // 处理结果
                        ((TextView)findViewById(R.id.rx_java_text)).setText(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // 处理错误
                    }

                    @Override
                    public void onComplete() {
                        // 操作完成的操作
                    }
                });

    }

    private void rx1(){
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        observable
                .filter(num -> num % 2 == 0) // 过滤偶数
                .map(num -> num * 2) // 将偶数乘以2
                .subscribe(result -> {
                    Log.d("song_text",""+result); // 输出结果
                });

    }
}
