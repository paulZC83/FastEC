package cn.sh.changxing.latte.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import cn.sh.changxing.latte.app.Latte;

/**
 * Created by ZengChao on 2018/1/26.
 */

public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.heightPixels;
    }
}
