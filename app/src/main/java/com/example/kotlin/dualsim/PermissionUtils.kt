package com.example.kotlin.dualsim

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat

object PermissionUtils {/*Build.VERSION_CODES.M*/
    val isNeedRequestPermission: Boolean
        get() = Build.VERSION.SDK_INT >=  /*Build.VERSION_CODES.M*/23

    fun checkSelfPermission(context: Context, permission: String?): Boolean {
        val pm = context.packageManager
        return PackageManager.PERMISSION_GRANTED == pm.checkPermission(permission!!, context.packageName)
    }

    fun requestPermission(activity: Activity?, permissions: Array<String?>?, requestCode: Int) {
        ActivityCompat.requestPermissions(activity!!, permissions!!, requestCode)
    }

}