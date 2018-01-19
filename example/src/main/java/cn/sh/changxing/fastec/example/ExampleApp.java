package cn.sh.changxing.fastec.example;

import android.app.Application;

import cn.sh.changxing.latte.app.Latte;

/**
 * Created by ZengChao on 2018/1/18.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
