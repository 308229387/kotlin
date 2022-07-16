package com.example.kotlin.utils.file_open;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;

/**
 * Describe ：打开本地文档用这个，创建个new File(path)，打开时会有后缀判断类型，再通过类型系统通知相关软件打开。
 */
public class FileOpen {

    public static void openFile(Context mContext, File file) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uriForFile;
            //Android 7.0之后
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
                uriForFile = FileProvider.getUriForFile(mContext, mContext.getPackageName().concat(".fileProvider"), file);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            } else {
                uriForFile = Uri.fromFile(file);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//系统会检查当前所有已创建的Task中是否有该要启动的Activity的Task;
            // 若有，则在该Task上创建Activity；若没有则新建具有该Activity属性的Task，并在该新建的Task上创建Activity。
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setDataAndType(uriForFile, getMimeTypeFromFile(file));
            ResolveInfo ri = mContext.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
            if (ri == null) {
                Toast.makeText(mContext, "请安装相应软件打开该文件", Toast.LENGTH_SHORT).show();
            } else {
                mContext.startActivity(intent);
            }
        } catch (Exception e) {
            Log.d("song_test", e.getMessage());
        }

    }

    /**
     * 使用自定义方法获得文件的MIME类型
     */
    private static String getMimeTypeFromFile(File file) {
        String type = "*/*";
        String fName = file.getName();
        //获取后缀名前的分隔符"."在fName中的位置。
        int dotIndex = fName.lastIndexOf(".");
        if (dotIndex > 0) {
            //获取文件的后缀名
            String end = fName.substring(dotIndex).toLowerCase(Locale.getDefault());
            //在MIME和文件类型的匹配表中找到对应的MIME类型。
            HashMap<String, String> map = SupportMineType.getMimeMap();
            if (!TextUtils.isEmpty(end) && map.containsKey(end)) {
                type = map.get(end);
            }
        }
        return type;
    }
}
