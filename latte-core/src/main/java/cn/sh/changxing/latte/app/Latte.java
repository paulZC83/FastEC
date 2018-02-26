package cn.sh.changxing.latte.app;

import android.content.Context;
import android.os.Handler;

/**
 * Created by ZengChao on 2018/1/18.
 */

/*
 * 对外的工具类
 */
public final class Latte {

    public static Configurator init(Context context){
        Configurator.getInstance().getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator(){
        return Configurator.getInstance();
    }

    public static <T>T getConfigurations(Object key){
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext(){
        return (Context) getConfigurations(ConfigKeys.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfigurations(ConfigKeys.HANDLER);
    }
}
