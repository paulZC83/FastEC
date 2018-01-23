package cn.sh.changxing.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by ZengChao on 2018/1/18.
 */

/*
 * 对外的工具类
 */
public final class Latte {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfigurations(){
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication(){
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
