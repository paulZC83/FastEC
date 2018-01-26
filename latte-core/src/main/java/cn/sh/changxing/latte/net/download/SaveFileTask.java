package cn.sh.changxing.latte.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;

import java.io.File;
import java.io.InputStream;

import cn.sh.changxing.latte.app.Latte;
import cn.sh.changxing.latte.net.callback.IRequest;
import cn.sh.changxing.latte.net.callback.ISuccess;
import cn.sh.changxing.latte.utils.FileUtil;
import okhttp3.ResponseBody;

/**
 * Created by ZengChao on 2018/1/26.
 */

public class SaveFileTask extends AsyncTask<Object, Void, File> {
    private final ISuccess SUCCESS;
    private final IRequest REQUEST;

    public SaveFileTask(ISuccess success, IRequest request) {
        this.SUCCESS = success;
        this.REQUEST = request;
    }

    @Override
    protected File doInBackground(Object... params) {
        String downloadDir = (String) params[0];
        String extension = (String) params[1];
        final ResponseBody responseBody = (ResponseBody) params[2];
        final String name = (String) params[3];
        if (TextUtils.isEmpty(downloadDir)) {
            // 设定默认值
            downloadDir = "download_dir";
        }
        if (TextUtils.isEmpty(extension)) {
            // 设定默认值
            extension = "";
        }
        final InputStream in = responseBody.byteStream();
        if (TextUtils.isEmpty(name)) {
            return FileUtil.writeToDisk(in, downloadDir, extension.toUpperCase(), extension);
        } else {
            return FileUtil.writeToDisk(in, downloadDir, name);
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (SUCCESS != null) {
            SUCCESS.onSuccess(file.getPath());
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }
        autoInstallApk(file);
    }


    private void autoInstallApk(File file) {
        if ("apk".equals(FileUtil.getExtension(file.getPath()))) {
            Intent installIntent = new Intent();
            installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            installIntent.setAction(Intent.ACTION_VIEW);
            installIntent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            Latte.getApplicationContext().startActivity(installIntent);
        }
    }
}
