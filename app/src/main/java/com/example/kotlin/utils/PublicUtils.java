package com.example.kotlin.utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import org.json.JSONArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class PublicUtils {
    private static long lastClickTime = 0;

    /**
     * 压缩文件和文件夹
     *
     * @param srcFileString 要压缩的文件或文件夹
     * @param zipFileString 压缩完成的Zip路径
     * @throws Exception
     */
    public static void ZipFolder(String srcFileString, String zipFileString) throws Exception {
        //创建ZIP
        ZipOutputStream outZip = new ZipOutputStream(new FileOutputStream(zipFileString));
        //创建文件
        File file = new File(srcFileString);
        //压缩
        Log.i("song_test", "---->" + file.getParent() + "===" + file.getAbsolutePath());
        ZipFiles(file.getParent() + File.separator, file.getName(), outZip);
        //完成和关闭
        outZip.finish();
        outZip.close();
    }

    /**
     * 压缩文件
     *
     * @param folderString
     * @param fileString
     * @param zipOutputSteam
     * @throws Exception
     */
    private static void ZipFiles(String folderString, String fileString, ZipOutputStream zipOutputSteam) throws Exception {
        Log.i("song_test", "folderString:" + folderString + "\n" +
                "fileString:" + fileString + "\n==========================");
        if (zipOutputSteam == null)
            return;
        File file = new File(folderString + fileString);
        if (file.isFile()) {
            ZipEntry zipEntry = new ZipEntry(fileString);
            FileInputStream inputStream = new FileInputStream(file);
            zipOutputSteam.putNextEntry(zipEntry);
            int len;
            byte[] buffer = new byte[4096];
            while ((len = inputStream.read(buffer)) != -1) {
                zipOutputSteam.write(buffer, 0, len);
            }
            zipOutputSteam.closeEntry();
        } else {
            //文件夹
            String fileList[] = file.list();
            //没有子文件和压缩
            if (null != fileList) {
                if (fileList.length <= 0) {
                    ZipEntry zipEntry = new ZipEntry(fileString + File.separator);
                    zipOutputSteam.putNextEntry(zipEntry);
                    zipOutputSteam.closeEntry();
                }
                //子文件和递归
                for (int i = 0; i < fileList.length; i++) {
                    ZipFiles(folderString + fileString + "/", fileList[i], zipOutputSteam);
                }
            } else {
                //TODO:要捕捉异常，如果是空，就是没有文件
                NullPointerException e = new NullPointerException();
                throw new NullPointerException();
            }

        }
    }



    public static String MapToJson(Map<String, String> map) {
        List<Map<String, String>> maplist = new ArrayList<Map<String, String>>();
        maplist.add(map);
        JSONArray obj = new JSONArray(maplist);
        return obj.toString();
    }

    public static void hideSoftKeyBoard(View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * 是否是持续点击？
     *
     * @return true：不是持续点击； false：持续点击；
     */
    public static boolean isCanClick() {
        long currentTime = System.currentTimeMillis();
        boolean isClick;
        if (currentTime - lastClickTime > 500) {
            isClick = true;
        } else {
            isClick = false;
        }
        lastClickTime = currentTime;
        return isClick;
    }

    /**
     * 是否是快速点击？
     *
     * @return true：间隔超过1S； false：1S内快速点击；
     */
    public static boolean isCanQuickClick() {
        long currentTime = System.currentTimeMillis();
        boolean isClick;
        if (currentTime - lastClickTime > 1000) {
            isClick = true;
            lastClickTime = currentTime;
        } else {
            isClick = false;
        }
        return isClick;
    }


}
