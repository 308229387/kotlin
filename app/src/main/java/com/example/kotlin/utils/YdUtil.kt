package com.example.kotlin.utils

import android.annotation.SuppressLint
import android.content.ClipboardManager
import com.example.kotlin.App
import java.io.ByteArrayOutputStream
import java.io.Closeable
import java.io.IOException
import java.io.InputStream

class YdUtil {

    companion object {
        private fun close(closeable: Closeable?) {
            if (closeable != null) {
                try {
                    closeable.close()
                } catch (var2: IOException) {
                    var2.printStackTrace()
                }
            }
        }

        fun readAndClose(`is`: InputStream?): String? {
            val result: String = read(`is`)!!
            close(`is`)
            return result
        }

        private fun read(`is`: InputStream?): String? {
            return if (`is` == null) {
                null
            } else {
                val result = ByteArrayOutputStream()
                try {
                    val buffer = ByteArray(1024)
                    var length: Int
                    while (`is`.read(buffer).also { length = it } != -1) {
                        result.write(buffer, 0, length)
                    }
                    result.toString("UTF-8")
                } catch (var4: IOException) {
                    var4.printStackTrace()
                    null
                }
            }
        }

        @SuppressLint("WrongConstant")
        fun getCopyText(): CharSequence? {
            val clipboard = App.getAppContext()!!.getSystemService("clipboard") as ClipboardManager
            return if (clipboard == null) {
                null
            } else {
                val clip = clipboard.primaryClip
                clip?.getItemAt(0)?.text
            }
        }

    }

}
