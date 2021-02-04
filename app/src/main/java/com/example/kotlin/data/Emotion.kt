package com.example.kotlin.data

import android.text.TextUtils
import com.example.kotlin.R
import org.json.JSONObject
import java.io.Serializable

class Emotion : Serializable {

    private var desc: String? = null

    /**
     * 真正的表情资源
     */
    private var res: String? = null

    /**
     * 表情资源的预览，可用于gif表情的预览
     */
    private val preview: String? = null
    private var display = true

    constructor(desc: String, res: String) {
        this.desc = desc
        this.res = desc
    }

    fun getRes(): String? {
        return res
    }

    fun setRes(res: String?) {
        this.res = res
    }

    companion object {
        val GIF_TAG = "#gif#"
        val DEL = Emotion("delete", "delete_emotion")
        private const val serialVersionUID = 1L
        val NULL = Emotion("null", "null")


        //仅仅用来占用一下，防止lint检查时，报R.drawable.delete_emotion是多余的资源
        var id: Int = R.mipmap.delete_emotion

        fun fromJson(jsonObject: JSONObject): Emotion? {
            if (jsonObject == null) {
                return null
            }
            val emotion = Emotion()
            val originContent = jsonObject.optString("content")
            if (!TextUtils.isEmpty(originContent)) {
                emotion.desc = originContent.toLowerCase().replace(GIF_TAG, "")
            }
            emotion.res = jsonObject.optString("url")
            emotion.display = jsonObject.optBoolean("display", true)
            return emotion
        }
    }

    constructor()


}