package com.example.kotlin.data

import com.example.kotlin.R
import java.io.Serializable

class Emotion(desc: String) : Serializable {
    var desc: String? = null
    private var res: String? = desc
    var path: String? = null

    fun getRes(): String? {
        return res
    }

    companion object {
        val DEL = Emotion("delete")
        private const val serialVersionUID = 1L
        val NULL = Emotion("null")
        var id: Int = R.mipmap.delete_emotion
    }

}