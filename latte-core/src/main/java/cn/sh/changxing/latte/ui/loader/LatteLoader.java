package cn.sh.changxing.latte.ui.loader;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

import cn.sh.changxing.latte.R;
import cn.sh.changxing.latte.utils.dimen.DimenUtil;

/**
 * Created by ZengChao on 2018/1/26.
 */

public class LatteLoader {
    // 缩放比
    private static final int LOADER_SIZE_SCALE = 8;
    // 偏移量
    private static final int LOADER_OFFSET_SCALE = 10;
    private static ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();
    // 默认loader
    private static String DEFAULT_LOADER = LoaderStyle.BallClipRotateIndicator.name();

    public static void showLoading(Context context, String type) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
        final AVLoadingIndicatorView loadingIndicatorView = LoaderCreator.create(type, context);
        dialog.setContentView(loadingIndicatorView);
        int width = DimenUtil.getScreenWidth();
        int height = DimenUtil.getScreenHeight();
        Window dialogWindow = dialog.getWindow();
        if (dialogWindow != null) {
            WindowManager.LayoutParams params = dialogWindow.getAttributes();
            params.width = width / LOADER_SIZE_SCALE;
            params.height = height / LOADER_SIZE_SCALE;
            params.height = params.height + height / LOADER_OFFSET_SCALE;
            params.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                }
            }
        }
    }

}
