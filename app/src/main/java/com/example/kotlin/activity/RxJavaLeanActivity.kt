package com.example.kotlin.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.rx_java_learn_layout.*


/**
 * Author: sym
 * Date: 2021/7/13 7:34 PM
 * Describe:
 */
class RxJavaLeanActivity : AppCompatActivity() {
    var TAG = "song_test"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rx_java_learn_layout)
        tryRxjava2ByKotlin()


    }

    private fun tryRxjava2ByKotlin() {
        val mObservable = Observable.create(ObservableOnSubscribe<String> {
            it.onNext("北京")
            it.onNext("生活")
            it.onNext("精彩")
            it.onComplete()
        })

        val mObserver = object : Observer<String> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: String) {
                rx_java_text.text = t
            }

            override fun onError(e: Throwable) {
            }

        }
        mObservable.subscribe(mObserver)
    }


}