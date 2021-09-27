package com.example.kotlin.activity

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.databinding.ActivityPermissionBinding
import com.example.kotlin.dualsim.PermissionUtils
import com.example.kotlin.utils.SimplePermissionUtil
import com.example.kotlin.utils.permissionutil.PermissionListener
import com.example.kotlin.utils.permissionutil.PermissionUtil
import com.example.kotlin.views.dialog.RecordSettingDialog

/**
 * Author: sym
 * Date: 2021/4/27 7:06 PM
 * Describe:除了在这里写，还要在manifest里声明权限
 */
class PermissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPermissionBinding
    private lateinit var dialog: RecordSettingDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dialog = RecordSettingDialog(this)

        val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        binding.autoPhoneBtn.setOnClickListener {
            SimplePermissionUtil.requestPermissions(this@PermissionActivity, permissions, 100)
        }
        binding.autoRecordBtn.setOnClickListener {
            val permissions1 = arrayOf(Manifest.permission.RECORD_AUDIO)
            SimplePermissionUtil.requestPermissions(this@PermissionActivity, permissions1, 100)
        }
        binding.customRecordBtn.setOnClickListener {
            /**
             * 点击检查 相机、打电话 权限
             *    <uses-permission android:name="android.permission.CAMERA" />
             *      <uses-permission android:name="android.permission.CALL_PHONE" />
             */
            val permissionUtil = PermissionUtil(this@PermissionActivity)
            permissionUtil.requestPermissions(arrayOf(Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE),
                object : PermissionListener {
                    override fun onGranted() {
                        Toast.makeText(this@PermissionActivity, "所有权限都已授权", Toast.LENGTH_SHORT).show()
                    }

                    override fun onDenied(deniedPermission: MutableList<String>?) {
                        //Toast第一个被拒绝的权限
                        Toast.makeText(this@PermissionActivity, "拒绝了权限" + deniedPermission!![0], Toast.LENGTH_LONG).show()
                    }

                    override fun onShouldShowRationale(deniedPermission: MutableList<String>?) {
                        showDialog()
                    }

                })


        }


    }

    private fun showDialog() {
        dialog.setLeftAndRightText(
            getString(R.string.virtual_dialog_not_allow),
            getString(R.string.virtual_dialog_setting)
        )
        dialog.setAttributes(this)
        dialog.setListener(object : RecordSettingDialog.RecordDialogCallBack {
            override fun result() {
                PermissionUtil.gotoPermission(this@PermissionActivity)
                dialog.dismiss()
            }

            override fun cancel() {
                dialog.dismiss()
            }

        }).show()
    }
}