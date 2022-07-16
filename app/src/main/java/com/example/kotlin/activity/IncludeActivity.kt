package com.example.kotlin.activity

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.ImageSwitcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_include_layout.*
import kotlinx.android.synthetic.main.include_layout.*


class IncludeActivity : AppCompatActivity() {
    private lateinit var vEmojiSwitcher: ImageSwitcher
    private var switcherTag: Boolean = false
//    val textSource = Html.fromHtml("修改TextView中部分文字的<font color='#ff0000'><big>大</big><small>小</small></font>和<font color='#00ff00'>颜色</font>，展示多彩效果！")

    val textSource = Html.fromHtml("<html>\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "</head>\n" +
            "<body>\n" +
            "<h3><font color=#007AAA>新橙慧安-合成研判平台</font></h3>\n" +
            "<span style=\"font-size: 13px\">为县级警方量身打造的专业化、智能化、一体化的综合研判平台。对接视频、人脸、车辆卡口、热点、GIS地图五大系统，应用AI、大数据、可视化技术，基于GIS地图关联融合数据资源，打通应用体系，通过系统合成作战，提升案件侦查、治安管控、目标核查等综合研判能力，提升基层警方的整体作战能力。</span>\n" +
            "\n" +
            "<h3><font color=#007AAA>产品优势</font></h3>\n" +
            "<h4>数据融合</h4>\n" +
            "<span style=\"font-size: 13px\">平台可对基层公安机关视频、人脸、卡口、热点等多类数据进行融合运用，打破壁垒，打造一体化实战平台。</span>\n" +
            "<h4>多维算法</h4>\n" +
            "<span style=\"font-size: 13px\">系统搭载视频目标识别、目标追踪、人脸比对、OCR识别等多种AI算法，深度支持智能化应用。</span>\n" +
            "<h4>合成作战</h4>\n" +
            "<span style=\"font-size: 13px\">平台支持系统级对接，支持多维研判，真正实现信息流、业务流层面的合成作战工作模式。</span>\n" +
            "<h4>精准研判</h4>\n" +
            "<span style=\"font-size: 13px\">系统高度场景化设计，聚焦在基层警方本地数据最高频应用功能，结合新橙慧兴-智能化实战工具能力，可有效精准研判。</span>\n" +
            "\n" +
            "<h3><font color=#007AAA>应用场景</font></h3>\n" +
            "<span style=\"font-weight: bold;font-size: 13px\">案件研判</span>&nbsp;&nbsp;\n" +
            "<span style=\"font-weight: bold;font-size: 13px\">治安管控</span>&nbsp;&nbsp;\n" +
            "<span style=\"font-weight: bold;font-size: 13px\">人员核查</span>&nbsp;&nbsp;\n" +
            "<span style=\"font-weight: bold;font-size: 13px\">反恐处突</span>\n" +
            "< img src=\"xc_product/180601820_img2.png\"/>\n" +
            "</body>\n" +
            "</html>")
//    val textSource = Html.fromHtml("<html>\n" +
//            "<head>\n" +
//            "    <meta charset=\"UTF-8\">\n" +
//            "</head>\n" +
//            "<body>\n" +
//
//            "<h3><font color=#007AAA>新橙慧安-合成研判平台</font></h3>\n" +
//
//            "<span style=\"font-size: 13px\">为县级警方量身打造的专业化、智能化、一体化的综合研判平台。对接视频、人脸、车辆卡口、热点、GIS地图五大系统，应用AI、大数据、可视化技术，基于GIS地图关联融合数据资源，打通应用体系，通过系统合成作战，提升案件侦查、治安管控、目标核查等综合研判能力，提升基层警方的整体作战能力。</span>\n" +
//            "\n" +
//            "<h3><font color=#007AAA>产品优势</font></h3>\n" +
//            "<h4>数据融合</h4>\n" +
//            "<span style=\"font-size: 13px\">平台可对基层公安机关视频、人脸、卡口、热点等多类数据进行融合运用，打破壁垒，打造一体化实战平台。</span>\n" +
//            "<h4>多维算法</h4>\n" +
//            "<span style=\"font-size: 13px\">系统搭载视频目标识别、目标追踪、人脸比对、OCR识别等多种AI算法，深度支持智能化应用。</span>\n" +
//            "<h4>合成作战</h4>\n" +
//            "<span style=\"font-size: 13px\">平台支持系统级对接，支持多维研判，真正实现信息流、业务流层面的合成作战工作模式。</span>\n" +
//            "<h4>精准研判</h4>\n" +
//            "<span style=\"font-size: 13px\">系统高度场景化设计，聚焦在基层警方本地数据最高频应用功能，结合新橙慧兴-智能化实战工具能力，可有效精准研判。</span>\n" +
//            "\n" +
//            "<h3><font color=#007AAA>应用场景</font></h3>\n" +
//            "<span style=\"font-weight: bold;font-size: 13px\">案件研判</span>&nbsp;&nbsp;\n" +
//            "<span style=\"font-weight: bold;font-size: 13px\">治安管控</span>&nbsp;&nbsp;\n" +
//            "<span style=\"font-weight: bold;font-size: 13px\">人员核查</span>&nbsp;&nbsp;\n" +
//            "<span style=\"font-weight: bold;font-size: 13px\">反恐处突</span>\n" +
//            "<img src=\"xc_product/180601820_img2.png\"/>\n" +
//            "</body>\n" +
//            "</html>")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_include_layout)
        tv_setting_update_app_title.setOnClickListener {
            Toast.makeText(this, tv_setting_update_app_title.text, Toast.LENGTH_SHORT).show()
        }

        var i ={ x: Int, y: Int->x+y}
        i(2, 3)

        var j : (Int, Int)->Int = { x, y -> x+y}

        vEmojiSwitcher = emoji_switcher

        result_for.text = forResult()

        setOnListener()
        html_text.text = textSource
    }

  

    private fun setOnListener() {
        visible_test.setOnClickListener {
            if (include_parent.visibility == View.GONE) {
                include_parent.visibility = View.VISIBLE
            } else if (include_parent.visibility == View.VISIBLE) {
                include_parent.visibility = View.GONE
            }
        }

        //表情键
        vEmojiSwitcher.setOnClickListener {
            if (switcherTag) {
                switchEmoji(1)
                switcherTag = false
            } else {
                switchEmoji(0)
                switcherTag = true
            }

        }
    }

    //表情与键盘标记切换
    private fun switchEmoji(index: Int) {
        if (vEmojiSwitcher.displayedChild == index) {
            return
        }
        if (index == 0) {
            vEmojiSwitcher.displayedChild = 0
        } else if (index == 1) {
            vEmojiSwitcher.displayedChild = 1
        }
    }

    //区间for循环
    private fun forResult(): String {
        val temp = 1..10
        val temp1 = 1 until 10
        val temp2 = 1 until 20
        val str = StringBuffer()
        val str1 = StringBuffer()
        val str2 = StringBuffer()

        for (i in temp) {
            str.append("$i")
        }

        for (i in temp1) {
            str1.append(i)
        }

        for (i in temp2 step 2) {
            str2.append("$i ")
        }
        return "..区间for循环：$str  \n until闭区间for循环：$str1 \n step+until闭区间for循环：$str2"
    }

}