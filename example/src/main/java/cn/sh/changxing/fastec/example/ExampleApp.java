package cn.sh.changxing.fastec.example;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import cn.sh.changxing.latte.app.Latte;
import cn.sh.changxing.latte.ec.database.DatabaseManager;
import cn.sh.changxing.latte.ec.icon.FontECModule;
import cn.sh.changxing.latte.net.interceptors.DebugInterceptor;

/**
 * Created by ZengChao on 2018/1/18.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule()) // 引用现成的(FontAwesome)ICON
                .withIcon(new FontECModule()) // 自定义字体,来源阿里巴巴矢量图标库,本地存放在assets目录下的tff文件
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                .configure();
        initStetho();
        DatabaseManager.getInstance().init(this);
    }

    private void initStetho(){
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        );
    }
}
