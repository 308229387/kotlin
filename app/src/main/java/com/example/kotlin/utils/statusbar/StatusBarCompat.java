package com.example.kotlin.utils.statusbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by 黄振伟 on 2017/2/9.
 */

public class StatusBarCompat {
    private static final int COLOR_DEFAULT = 0x50000000;
    /***
     * 沉浸模式 sdk>=19
     */
    public static void compatImmersive(Activity activity, boolean isDark) {
        setStatusBarTransparent(activity);
        setStatusBarIconColor(activity, isDark);
    }
    /***
     * 设置状态栏透明,内容延伸到状态栏区域
     */
    private static void setStatusBarTransparent(Activity activity) {
        setRootViewFitsSystemWindows(activity, false);
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        int visibility = window.getDecorView().getSystemUiVisibility();
        visibility |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        visibility |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        window.getDecorView().setSystemUiVisibility(visibility);
    }
    /***
     *  设置状态栏图标颜色
     * @param isDark 设置状态栏图标颜色为黑色或者白色
     */
    private static void setStatusBarIconColor(Activity activity, boolean isDark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setCommonUI(activity, isDark);
        } else if (OSUtils.isMiui()) {
            setMiuiUI(activity, isDark);
        } else if (OSUtils.isFlyme()) {
            setFlymeUI(activity, isDark);
        }
    }

    /***
     * 修改状态栏颜色，内容不延伸进状态栏区域，设置图标颜色
     */
    public static void compat(Activity activity, int statusColor, boolean isDark) {
        setStatusBarIconColor(activity, isDark);
        setStatusColorBackground(activity, statusColor);
    }

    /***
     * 修改状态栏颜色,内容不延伸进状态栏区域
     */
    private static void setStatusColorBackground(Activity activity, int statusColor) {
        setRootViewFitsSystemWindows(activity, true);
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M || OSUtils.isFlyme() || OSUtils.isMiui()) {
            window.setStatusBarColor(statusColor);
        } else {
            window.setStatusBarColor(COLOR_DEFAULT);
        }
    }

    /**
     * 代码实现android:fitsSystemWindows
     */
    private static void setRootViewFitsSystemWindows(Activity activity, boolean fitSystemWindows) {
        ViewGroup mContentView = activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            mChildView.setFitsSystemWindows(fitSystemWindows);
        }
    }

    //设置6.0 状态栏深色浅色切换
    private static void setCommonUI(Activity activity, boolean dark) {
        View decorView = activity.getWindow().getDecorView();
        if (decorView != null) {
            int vis = decorView.getSystemUiVisibility();
            if (dark) {
                vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            } else {
                vis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
            if (decorView.getSystemUiVisibility() != vis) {
                decorView.setSystemUiVisibility(vis);
            }
        }
    }

    //设置Flyme 状态栏深色浅色切换
    private static void setFlymeUI(Activity activity, boolean dark) {
        try {
            Window window = activity.getWindow();
            WindowManager.LayoutParams lp = window.getAttributes();
            Field darkFlag = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field meizuFlags = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            darkFlag.setAccessible(true);
            meizuFlags.setAccessible(true);
            int bit = darkFlag.getInt(null);
            int value = meizuFlags.getInt(lp);
            if (dark) {
                value |= bit;
            } else {
                value &= ~bit;
            }
            meizuFlags.setInt(lp, value);
            window.setAttributes(lp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //设置MIUI 状态栏深色浅色切换
    private static void setMiuiUI(Activity activity, boolean dark) {
        try {
            Window window = activity.getWindow();
            Class<?> clazz = activity.getWindow().getClass();
            @SuppressLint("PrivateApi") Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            int darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getDeclaredMethod("setExtraFlags", int.class, int.class);
            extraFlagField.setAccessible(true);
            if (dark) {    //状态栏亮色且黑色字体
                extraFlagField.invoke(window, darkModeFlag, darkModeFlag);
            } else {
                extraFlagField.invoke(window, 0, darkModeFlag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static void setHeightAndPadding(Context context, View view) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height += getStatusBarHeight(context);
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
        }
    }
}
