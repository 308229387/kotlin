package com.example.kotlin.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.dualsim.PermissionUtils
import com.example.kotlin.dualsim.TelephonyManagement
import kotlinx.android.synthetic.main.activity_imei.*

class ImeiActivity : AppCompatActivity() {
    lateinit var telephonyInfo: TelephonyManagement.TelephonyInfo
    lateinit var data: StringBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imei)
        data = StringBuilder()
        imei_button.setOnClickListener {
            if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(Manifest.permission.READ_PHONE_STATE) !== PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.READ_PHONE_STATE), 100)
            } else {
                isDualSimOrNot()
            }
        }

        if (!PermissionUtils.isNeedRequestPermission) {
            checkSimCard()
        } else {
            if (!PermissionUtils.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)) {
                PermissionUtils.requestPermission(this, arrayOf(Manifest.permission.READ_PHONE_STATE), 100)
            } else {
                checkSimCard()
            }
        }

    }


    private fun checkSimCard() {
        telephonyInfo = TelephonyManagement.instance?.updateTelephonyInfo(this)?.getTelephonyInfo(this)!!
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                isDualSimOrNot()
            } else {
                Toast.makeText(this, "用户拒绝授权！", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isDualSimOrNot() {
        if (data.length > 1) {
            data.delete(0, data.length - 1)
        }
        checkSimCard()
        val imeiSIM1 = telephonyInfo.imeiSIM1
        val imeiSIM2 = telephonyInfo.imeiSIM2
        data.append(
            " IMEI1 : " + imeiSIM1 + "\n" +
                    " IMEI2 : " + imeiSIM2 + "\n"
        )
        imei_text.text = data.toString()
    }

}