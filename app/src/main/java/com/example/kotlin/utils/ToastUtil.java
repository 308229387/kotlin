package com.example.kotlin.utils;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.StringRes;

import com.example.kotlin.R;


public class ToastUtil {

    private static Toast sToast;

    /**
     * 显示一个View为TextView的Toast
     */
    public static void showTextViewPrompt(@StringRes int textResId) {
        showTextViewPrompt(AppContextUtils.getAppContext(), AppContextUtils.getAppContext().getString(textResId));
    }

    /**
     * 重载的方法，同上
     */
    public static void showTextViewPrompt(String name) {
        if(TextUtils.isEmpty(name)){
            return;
        }
        showTextViewPrompt(AppContextUtils.getAppContext(), name);
    }

    public static void showTextViewPrompt(Context context, String name) {
        showVerboseToast(name);
    }

    public static void showTextViewPromptShort(Context context, String name) {
        showVerboseToast(name);
    }

    public static void showTextViewPromptLong(Context context, String name) {
        showVerboseToastLong(name);
    }

    public static void showImageViewPromptShort(Context context, String showContent) {
        showOkToast(showContent);
    }

    public static void showImageViewPromptLong(Context context, String showContent) {
        showOkToastLong(showContent);
    }

    /**
     * 显示正确的Toast
     */
    public static void showOkToast(String text) {
        View v = getShowView(text, 0);
        if (v == null) {
            return;
        }
        getToast(v, false).show();
    }

    public static void showOkToastLong(String text) {
        View v = getShowView(text, 0);
        if (v == null) {
            return;
        }
        getToast(v, true).show();
    }

    /**
     * 显示错误的Toast
     */
    public static void showErrorToast(String text) {
        View v = getShowView(text, 1);
        if (v == null) {
            return;
        }
        getToast(v, false).show();
    }

    public static void showErrorToastLong(String text) {
        View v = getShowView(text, 1);
        if (v == null) {
            return;
        }
        getToast(v, true).show();
    }

    /**
     * 显示警告的Toast
     */
    public static void showWarnToast(String text) {
        View v = getShowView(text, 2);
        if (v == null) {
            return;
        }
        getToast(v, false).show();
    }

    public static void showWarnToastLong(String text) {
        View v = getShowView(text, 2);
        if (v == null) {
            return;
        }
        getToast(v, true).show();
    }

    /**
     * 展示使用方传递的图片与文字
     */
    public static void showCustomImage(Drawable drawable, String text) {
        View v = getCustomView(drawable, text);
        if (v == null) {
            return;
        }
        getToast(v, false).show();
    }

    public static void showCustomImageLong(Drawable drawable, String text) {

        View v = getCustomView(drawable, text);
        if (v == null) {
            return;
        }
        getToast(v, true).show();
    }

    private static View getCustomView(Drawable drawable, String text) {
        if (drawable == null || TextUtils.isEmpty(text)) {
            return null;
        }
        View view = View.inflate(AppContextUtils.getAppContext(), R.layout.tc_toast_view_prompt, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_toast_prompt);
        ImageView im = (ImageView) view.findViewById(R.id.image_toast_prompt);
        tv.setText(text);
        tv.setGravity(Gravity.LEFT);
        im.setBackground(drawable);
        return view;
    }


    /**
     * 显示View为TextView 的Toast,默认时间Toast.LENGTH_SHORT
     */
    public static void showVerboseToast(String text) {
        View v = getShowView(text, 3);
        if (v == null) {
            return;
        }
        getToast(v, false).show();
    }

    public static void showVerboseToastLong(String text) {
        View v = getShowView(text, 3);
        if (v == null) {
            return;
        }
        getToast(v, true).show();
    }

    /**
     * Toast显示一个View
     *
     */
    public static void show(Context context, View view) {
        Toast toast = getToast(view, false);
        toast.show();
    }

    public static void showViewLong(Context context, View view) {
        Toast toast = getToast(view, true);
        toast.show();
    }


    /**
     * type： 0  正确View； 1 错误View ；2 警告 View ； 3 只显示文本
     */
    private static View getShowView(String text, int type) {
        if (TextUtils.isEmpty(text)) {
            return null;
        }
        View view = View.inflate(AppContextUtils.getAppContext(), R.layout.tc_toast_view_prompt, null);
        TextView tv = view.findViewById(R.id.tv_toast_prompt);
        ImageView im = view.findViewById(R.id.image_toast_prompt);
        tv.setText(text);
        tv.setGravity(Gravity.START);
        switch (type) {
            case 0:
                break;
            case 1:
//                im.setBackgroundResource(R.drawable.toast_show_error);
                break;
            case 2:
//                im.setBackgroundResource(R.drawable.toast_show_warn);
                break;
            case 3:
                tv.setGravity(Gravity.CENTER);
                im.setVisibility(View.GONE);
                break;
            default:
                break;
        }

        return view;
    }

    private static Toast getToast(View view, boolean isShowLong) {

        if (sToast == null) {
            Toast toast = new Toast(AppContextUtils.getAppContext());
            toast.setGravity(Gravity.BOTTOM, 0, 300);
            sToast = toast;
        }

        sToast.setDuration(isShowLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        sToast.setView(view);
        return sToast;
    }

}
