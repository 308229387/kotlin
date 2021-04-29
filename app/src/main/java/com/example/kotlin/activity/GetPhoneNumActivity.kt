package com.example.kotlin.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.telephony.TelephonyManager
import com.example.kotlin.base.BaseActivity
import com.example.kotlin.databinding.ActivityPhoneNumBinding
import com.tbruyelle.rxpermissions3.RxPermissions

/**
 * Author: sym
 * Date: 2021/4/29 10:54 AM
 * Describe:
 */
class GetPhoneNumActivity : BaseActivity<ActivityPhoneNumBinding>() {
    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPermissions()
    }

    override fun createViewBinding(): ActivityPhoneNumBinding {
        return ActivityPhoneNumBinding.inflate(layoutInflater)
    }

    @SuppressLint("MissingPermission")
    private fun getPermissions() {
        val permissions = RxPermissions(this)
        permissions.request(Manifest.permission.READ_PHONE_STATE)
            .subscribe {
                if (it) {
                    var tm = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                    if (tm.line1Number!=null) {
                        viewBind.phoneNumText.text = tm.line1Number
                    } else {
                        viewBind.phoneNumText.text = "无手机卡"
                    }
                } else {
                    viewBind.phoneNumText.text = "未获取权限"
                }
            }

    }

}