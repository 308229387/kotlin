package com.example.kotlin.activity

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.databinding.ActivityPermissionBinding
import com.example.kotlin.utils.PermissionCheckUtil

/**
 * Author: sym
 * Date: 2021/4/27 7:06 PM
 * Describe:除了在这里写，还要在manifest里声明权限
 */
class PermissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPermissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        binding.autoPhoneBtn.setOnClickListener {
            PermissionCheckUtil.requestPermissions(this@PermissionActivity, permissions, 100)
        }
        binding.autoRecordBtn.setOnClickListener {
            val permissions1 = arrayOf(Manifest.permission.RECORD_AUDIO)
            PermissionCheckUtil.requestPermissions(this@PermissionActivity, permissions1, 100)
        }
        binding.customRecordBtn.setOnClickListener {
            val permissions2 = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            PermissionCheckUtil.requestPermissions(this@PermissionActivity, permissions2, 100)
        }
    }
}