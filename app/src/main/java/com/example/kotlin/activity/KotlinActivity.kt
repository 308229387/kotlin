package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.android.synthetic.main.kotlin_about_layout.kotlin_title_text
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Author: sym
 * Date: 2021/7/13 7:34 PM
 * Describe:
 */
class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_about_layout)

        val scope = CoroutineScope(Dispatchers.Main) // 创建协程

        scope.launch {
            val result = fetchData() // 调用挂起函数
            kotlin_title_text.text = result
        }

//        scope.launch {
//            val deferredResult = async { fetchData() } // 异步执行挂起函数
//            val result = deferredResult.await() // 等待异步操作结果
//            kotlin_title_text.text = result+"异步"
//        }

//        scope.launch {
//            val result = withContext(Dispatchers.IO) { fetchData() } // 在后台线程执行挂起函数
//            kotlin_title_text.text = result+"切换线程"
//        }
    }

    private suspend fun fetchData(): String {
        delay(3000) // 模拟耗时操作
        return "kotlin协程3秒后赋值"
    }

}