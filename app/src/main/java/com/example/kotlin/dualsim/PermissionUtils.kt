package com.example.kotlin.dualsim

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat

/**
 * Title: CalendarController.java
 * Description: 权限操作类,主要供自身业务使用
 * Copyright: Copyright (c) 2016
 * Company:XXXXXXXXXXXXXXXX
 *
 * @author
 * @version 1.0
 * @CreateDate
 */
object PermissionUtils {/*Build.VERSION_CODES.M*/
    /**
     * check current sdk if >= 23
     *
     * @return true is need requestPermission
     */
    val isNeedRequestPermission: Boolean
        get() = Build.VERSION.SDK_INT >=  /*Build.VERSION_CODES.M*/23

    /**
     * @param context
     * @param permission [permission] or [android.Manifest.permission_group]
     * @return false need request Permission
     */
    fun checkSelfPermission(context: Context, permission: String?): Boolean {
        val pm = context.packageManager
        return PackageManager.PERMISSION_GRANTED == pm.checkPermission(permission!!, context.packageName)
        //        int result = ContextCompat.checkSelfPermission(context, permission);
//        return result == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * request Some ManiFest.Permission
     * use this method you need override [Activity.onRequestPermissionsResult]
     *
     * @param activity
     * @param permissions [permission] or [android.Manifest.permission_group]
     * @param requestCode can yo do some for onAactivityResult
     */
    fun requestPermission(activity: Activity?, permissions: Array<String?>?, requestCode: Int) {
        ActivityCompat.requestPermissions(activity!!, permissions!!, requestCode)
    }

    /**
     * user deny and never ask again
     * 当用户勾选了申请权限时不再显示，并且拒绝授权时 ，调用该方法检测，返回false 则用户不授予权限，需要弹窗告知用户需要权限的理由，并让其前往系统设置
     *
     * @param activity
     * @param permission
     * @return
     */
    fun shouldShowRequestPermissiomRationale(activity: Activity?, permission: String?): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity!!, permission!!)
    }

    /**
     * 请求权限
     *
     * @param activity
     * @param permission
     * @param
     * @return true 不需要申请权限  , false 需要申请权限后在操作
     * @CreateData
     */
    fun easyRequestPermission(activity: Activity, permission: String?, requestCode: Int): Boolean {
        if (isNeedRequestPermission) {
            if (!checkSelfPermission(activity, permission)) {
                requestPermission(activity, arrayOf(permission), requestCode)
                return false
            }
        }
        return true
    }
}