package com.example.kotlin.utils

import android.content.res.AssetManager
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.InsetDrawable
import android.text.*
import android.text.style.ImageSpan
import android.widget.EditText
import androidx.annotation.NonNull
import com.example.kotlin.App
import com.example.kotlin.data.Emotion
import com.example.kotlin.data.EmotionGroup
import com.example.kotlin.views.CenterAlignImageSpan
import com.google.gson.Gson
import java.io.InputStream
import java.lang.ref.SoftReference
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

@Suppress("DEPRECATION")
class EmotionHelper {

    companion object {
        private val EMOTION_MAP: Map<String, Emotion> = HashMap()
        const val EMOTION_CLASSIC_JSON = "emotions/classic/emotionGroup.json"
        const val EMOTION_DEFAULT_JSON = "emotions/default/emotionGroup.json"
        const val EMOTION_CLASSIC_DIR = "emotions/classic"
        const val EMOTION_DEFAULT_DIR = "emotions/default"
        const val EMOTION_GIF_JSON = "emotions/gif/gifGroup.json"
        private val DRAWABLE_CACHE: MutableMap<String, SoftReference<Drawable>> = HashMap()
        private val PATTERN_EMOTION = Pattern.compile("(\\[.*?])")


        //读取图片
        fun getDrawable(path: String): Drawable? {
            return try {
                val assetManager = App.getAppContext()!!.resources.assets
                val `is` = assetManager.open(path)
                val drawable = BitmapDrawable(BitmapFactory.decodeStream(`is`))
                drawable
            } catch (e: Exception) {
                null
            }
        }

        //获取JSON文件
        fun getAssetsJson(dir: String): String {
            val assetManager: AssetManager = App.getAppContext()!!.resources.assets
            val `is`: InputStream = assetManager.open(dir)
            return ToolsUtil.readAndClose(`is`)!!
        }

        //获取JSON文件
        fun getEmotionsGroup(dir: String): EmotionGroup {
            val json: String = getAssetsJson(dir)
            return Gson().fromJson(json, EmotionGroup::class.java)
        }

        //表情接入
        fun appendEmotion(editText: EditText, emotion: Emotion) {
            val selection = editText.selectionStart
            val editable = editText.text
            editable.replace(
                selection, editText.selectionEnd, getEmotionSpan(
                    emotion,
                    editText.textSize.toInt()
                )
            )
            editText.text = editable

            val maxLen = editText.text.length
            var index: Int = selection + emotion.desc!!.length
            if (index > maxLen) {
                index = maxLen
            }
            editText.setSelection(index)
        }

        //获取表情
        private fun getEmotionSpan(emotion: Emotion, size: Int): CharSequence {
            val desc: String = emotion.desc!!
            val key = desc + '_' + size
            var drawable: Drawable? = getDrawableFromCache(key)
            if (drawable == null) {
                drawable = getDrawable(emotion.path!!)!!
                putDrawableToCache(key, drawable)
            }
            val insetDrawable: Drawable = InsetDrawable(
                drawable,
                CenterAlignImageSpan.DRAWABLE_PADDING,
                0,
                CenterAlignImageSpan.DRAWABLE_PADDING,
                0
            )
            val scaleSize = (size / CenterAlignImageSpan.SCALE_BOUNDS).toInt() + 6
            insetDrawable.setBounds(
                0,
                0,
                scaleSize + (CenterAlignImageSpan.DRAWABLE_PADDING shl 1),
                scaleSize
            )
            val builder: Spannable = SpannableString(desc)
            val imageSpan: ImageSpan = CenterAlignImageSpan(insetDrawable)
            builder.setSpan(imageSpan, 0, desc.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            return builder
        }

        //缓存
        private fun getDrawableFromCache(key: String): Drawable? {
            return if (DRAWABLE_CACHE.containsKey(key)) {
                (DRAWABLE_CACHE[key] ?: error("")).get()
            } else null
        }

        //存入缓存
        private fun putDrawableToCache(@NonNull key: String, @NonNull drawable: Drawable) {
            val reference = SoftReference(drawable)
            DRAWABLE_CACHE[key] = reference
        }

        fun deleteEmotion(editText: EditText): Boolean {
            val editable = editText.text
            var indexStart: Int
            var indexEnd: Int

            val selectionStart = editText.selectionStart
            val selectionEnd = editText.selectionEnd

            if (selectionStart != selectionEnd) {
                indexStart = selectionStart
                indexEnd = selectionEnd
            } else {
                val str = editable.toString().substring(0, selectionStart)
                if (selectionStart > 0) {
                    indexStart = selectionStart - 1
                    indexEnd = selectionStart

                    if (str[selectionStart - 1] == ']') {
                        val index = str.lastIndexOf('[')
                        val emotionDesc = str.substring(index, selectionStart)
                        if (EMOTION_MAP.containsKey(emotionDesc)) {
                            indexStart = index
                            indexEnd = selectionStart
                        }
                    }
                } else {
                    indexStart = -1
                    indexEnd = -1
                }
            }
            return if (indexEnd < 0) {
                false
            } else {
                editable.delete(indexStart, indexEnd)
                //重新setText以便重新对文字进行布局
                editText.text = editable
                editText.setSelection(indexStart)
                true

            }
        }

        fun getEmotionText(text: CharSequence, textSize: Float): CharSequence {
            if (text.isEmpty()) {
                return ""
            }
            val str = text.toString()
            val indexStart = str.indexOf('[')
            val indexEnd = str.indexOf(']')

            if (indexStart < 0 || indexEnd < 0 || indexStart > indexEnd) {
                return text
            }
            val ss: Editable = SpannableStringBuilder(text)
            val matcher: Matcher = PATTERN_EMOTION.matcher(text)


            while (matcher.find()) {
                val result = matcher.toMatchResult()
                val s = result.group(0)
                val start = result.start(0)
                val end = result.end(0)
                if (EMOTION_MAP.containsKey(s)) {
                    val emotion = EMOTION_MAP[s]
                    ss.replace(start, end, getEmotionSpan(emotion!!, textSize.toInt()))
                }
            }
            return ss
        }
    }
}