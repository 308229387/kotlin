package com.example.kotlin.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.data.HawkConfig
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_j_d_search.*
import java.util.*

/**
 * Author: sym
 * Date: 2021/7/22 10:23 AM
 * Describe:仿京东搜索，想接入，三步：重写initImageView2(这就是收起和缩起的小按钮）、initImageView(这就是收起和缩起的小按钮)、initZFlowLayout，然后实现initZFlowLayout(),传入数据
 */
class JDSearchActivity : AppCompatActivity() {
    private var isDelete = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_j_d_search)
        initView()
    }

    private fun initView() {
        iv_clear.setOnClickListener { Toast.makeText(this@JDSearchActivity, "删除", Toast.LENGTH_SHORT).show() }
        edit_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                iv_clear.visibility = if (TextUtils.isEmpty(s)) View.GONE else View.VISIBLE
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        edit_search.setOnEditorActionListener(object : OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    hideSoftKeyboard()
                    saveSearchHistory(v)
                    notifyData()
                    return true
                }
                return false
            }
        })

        notifyData()
    }

    private fun saveSearchHistory(v: TextView?) {
        var searchHistory: MutableList<String> = if (Hawk.contains(HawkConfig.JDSearch)) {
            Hawk.get(HawkConfig.JDSearch)
        } else {
            mutableListOf()
        }
        if (v != null) {
            searchHistory.add(0, v.text.toString())
            Hawk.put(HawkConfig.JDSearch, searchHistory)
        }
    }

    private fun notifyData() {
        if (Hawk.contains(HawkConfig.JDSearch)) {
            var searchHistory: MutableList<String> = Hawk.get(HawkConfig.JDSearch)
            if (searchHistory != null && searchHistory.size >= 0) {
                initZFlowLayout(searchHistory)
            }
        }
        isDelete = -1
    }

    private val mViewList: MutableList<View> = ArrayList()


    private fun initZFlowLayout(searchHistory: MutableList<String>) {

        mViewList.clear()
        for (i in searchHistory.indices) {
            val textView = layoutInflater.inflate(R.layout.item_search_history, zl_search_history, false) as TextView
            textView.text = searchHistory[i]
            mViewList.add(textView)
        }
        zl_search_history.setChildren(mViewList)
        zl_search_history.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                zl_search_history.viewTreeObserver.removeOnGlobalLayoutListener(this)
                val lineCount: Int = zl_search_history.lineCount
                val twoLineViewCount: Int = zl_search_history.twoLineViewCount
                if (lineCount > 2) {
                    initImageView2(searchHistory, twoLineViewCount)
                }
            }
        })
        zl_search_history.setOnTagClickListener { view, position ->

            if (position == isDelete) {
                searchHistory.removeAt(position)
                Hawk.put(HawkConfig.JDSearch, searchHistory)
                notifyData()
                isDelete = -1
            } else {
                Toast.makeText(this@JDSearchActivity, "选择了${(view as TextView).text}", Toast.LENGTH_SHORT).show()
            }
        }

        zl_search_history.setOnLongClickListener { view, position ->
            (view as TextView).setCompoundDrawablesWithIntrinsicBounds(null, null, resources.getDrawable(R.mipmap.clip_search_delete_item_new), null)
            isDelete = position
        }


    }

    private fun hideSoftKeyboard() {
        try {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            if (imm != null) {
                val currentFocus = currentFocus
                if (currentFocus != null) {
                    imm.hideSoftInputFromWindow(currentFocus.windowToken, 0) //强制隐藏键盘
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun initImageView2(searchHistory: List<String>, twoLineViewCount: Int) {
        mViewList.clear()
        for (i in 0 until twoLineViewCount) {
            val textView = layoutInflater.inflate(R.layout.item_search_history, zl_search_history, false) as TextView
            textView.text = searchHistory[i]
            textView.text = searchHistory[i]
            mViewList.add(textView)
        }
        val imageView = layoutInflater.inflate(R.layout.item_search_history_img, zl_search_history, false) as ImageView
        imageView.setImageResource(R.mipmap.search_close)
        imageView.setOnClickListener { v: View? -> initImageView(searchHistory, twoLineViewCount) }
        mViewList.add(imageView)
        zl_search_history.setChildren(mViewList)
        zl_search_history.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                zl_search_history.viewTreeObserver.removeOnGlobalLayoutListener(this)
                val lineCount: Int = zl_search_history.lineCount
                val twoLineViewCount: Int = zl_search_history.twoLineViewCount
                if (lineCount > 2) {
                    initImageView2(searchHistory, twoLineViewCount - 1)
                }
            }
        })
    }

    private fun initImageView(searchHistory: List<String>, twoLineViewCount: Int) {
        mViewList.clear()
        for (i in searchHistory.indices) {
            val textView = layoutInflater.inflate(R.layout.item_search_history, zl_search_history, false) as TextView
            textView.text = searchHistory[i]
            textView.text = searchHistory[i]
            mViewList.add(textView)
        }
        val imageView = layoutInflater.inflate(R.layout.item_search_history_img, zl_search_history, false) as ImageView
        imageView.setImageResource(R.mipmap.search_open)
        imageView.setOnClickListener { v: View? -> initImageView2(searchHistory, twoLineViewCount) }
        mViewList.add(imageView)
        zl_search_history.setChildren(mViewList)
    }

}