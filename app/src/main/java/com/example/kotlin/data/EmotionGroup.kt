package com.example.kotlin.data

class EmotionGroup(private var needDelIcon: Boolean) {

    private var emotions: ArrayList<Emotion>? = null
    private val row = 3
    private val column = 7
    private var pageCount = 0
    private var hasSetup = false

    fun getEmotions(): List<Emotion>? {
        setupEmotions()
        return emotions
    }

    private fun getCountPerPage(): Int {
        return row * column
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
        for (i in pageCount downTo 1) {
            emotions!!.add(i * countPerPageExcludeDel, Emotion.DEL)
        }
    }

}