package com.example.kotlin.activity

import android.content.res.AssetManager
import android.graphics.BitmapFactory
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
        assets_text.text = getAssetsInfo().getEmotions()!![1].getRes()
        getImage()
    }

    private fun getAssetsInfo(): EmotionGroup {
        val assetManager: AssetManager = resources.assets

        val `is`: InputStream = assetManager.open("$EMOTION_DIR_ASSET/$dir/$EMOTION_JSON_FILE_NAME")
        val json: String = YdUtil.readAndClose(`is`)!!

        return Gson().fromJson(json, EmotionGroup::class.java)
    }

    private fun getImage(){
        try {
            val assetManager = assets
            val `is` = assetManager.open("ziyaxiao.png")
            //以下注释掉的代码不靠谱.若采用,会有异常
            //InputStream is = assetManager.open("file:///android_asset/Fresh_01.jpg");
            val bitmap = BitmapFactory.decodeStream(`is`)
            assets_image.setImageBitmap(bitmap)
            if (bitmap != null) {
                println("测试一:width=" + bitmap.width + " ,height=" + bitmap.height)
            } else {
                println("bitmap == null")
            }
        } catch (e: Exception) {
            println("异常信息:$e")
        }

    }
}