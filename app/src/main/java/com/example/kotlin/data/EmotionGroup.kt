package com.yidian.subway.newscontent.ui.comment

import com.example.kotlin.data.Emotion

class EmotionGroup {
    private var typeName: String? = null
    private var typeThumbnail: String? = null

    private val resType = RES_TYPE_UNKNOWN
    private var emotions: ArrayList<Emotion>? = null
    private val row = 3
    private val column = 7
    private var pageCount = 0
    private val size = 30
    private val rowMargin = 10f
    private var needDelIcon = false
    private val priority: Long = 0
    private var hasSetup = false

    companion object {
        const val RES_TYPE_UNKNOWN = 0
        const val RES_TYPE_ID = 1
        const val RES_TYPE_ASSET = 2
        const val RES_TYPE_FILE = 3
    }

    constructor(needDelIcon: Boolean) {
        this.needDelIcon = needDelIcon
    }

    fun setEmotions(emotions: ArrayList<Emotion>) {
        this.emotions = emotions
        hasSetup = false
    }

    fun getEmotions(): List<Emotion>? {
        setupEmotions()
        return emotions
    }

    private fun getCountPerPage(): Int {
        return row * column
    }

    fun setTypeThumbnail(typeThumbnail: String?) {
        this.typeThumbnail = typeThumbnail
    }

    fun getTypeThumbnail(): String? {
        return typeThumbnail
    }

    private fun setupEmotions() {
        if (hasSetup) {
            return
        }

        hasSetup = true
        var emotionCount = if (emotions == null) 0 else emotions!!.size
        val countPerPage: Int = getCountPerPage()
        if (!needDelIcon) {
            pageCount = (emotionCount + countPerPage - 1) / countPerPage
            return
        }

        val countPerPageExcludeDel = countPerPage - 1

        //补全最后一页非delIcon数量
        val nullCount = countPerPageExcludeDel - emotionCount % countPerPageExcludeDel
        for (i in 0 until nullCount) {
            emotions?.add(Emotion.NULL)
        }
        emotionCount += nullCount
        pageCount = emotionCount / countPerPageExcludeDel

        //为每一页添加delIcon

        //为每一页添加delIcon
        for (i in pageCount downTo 1) {
            emotions!!.add(i * countPerPageExcludeDel, Emotion.DEL)
        }
    }

}