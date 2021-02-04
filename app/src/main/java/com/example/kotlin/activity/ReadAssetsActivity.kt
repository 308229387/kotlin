package com.example.kotlin.activity

import android.content.res.AssetManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.utils.YdUtil
import com.google.gson.Gson
import com.yidian.subway.newscontent.ui.comment.EmotionGroup
import kotlinx.android.synthetic.main.activity_assets.*
import java.io.InputStream


class ReadAssetsActivity : AppCompatActivity() {
    val EMOTION_JSON_FILE_NAME = "emotionGroup.json"
    val EMOTION_DIR_ASSET = "emotions"
    val dir = "classic"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assets)
        assets_result.text = getAssetsInfo().getEmotions()!![1].getRes()
    }

    private fun getAssetsInfo(): EmotionGroup {
        val assetManager: AssetManager = resources.assets

        val `is`: InputStream = assetManager.open("$EMOTION_DIR_ASSET/$dir/$EMOTION_JSON_FILE_NAME")
        val json: String = YdUtil.readAndClose(`is`)!!

        return Gson().fromJson(json, EmotionGroup::class.java)
    }
}