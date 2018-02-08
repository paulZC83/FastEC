package cn.sh.changxing.latte.app;

import android.app.Activity;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;

/**
 * Created by ZengChao on 2018/1/18.
 */

public class Configurator {

    private static final HashMap<Object, Object> LATTE_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    private Configurator(){
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY, false);
    }

    /*------------------------线程安全的单例模式-------------------------------*/
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }
    /*------------------------线程安全的单例模式-------------------------------*/

    public final void configure(){
        initIcons();
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY, true);
    }

    final HashMap<Object, Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigKeys.API_HOST, host);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready, call configure!");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key){
        checkConfiguration();
        final Object value = LATTE_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString()+" IS NULL");
        }
        return (T)LATTE_CONFIGS.get(key);
    }

    public Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }

    public Configurator withInterceptor(Interceptor interceptor){
        INTERCEPTORS.add(interceptor);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public Configurator withInterceptors(ArrayList<Interceptor> interceptors){
        INTERCEPTORS.addAll(interceptors);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withWeChatAppId(String appId){
        LATTE_CONFIGS.put(ConfigKeys.WE_CHAT_APP_ID, appId);
        return this;
    }

    public final Configurator withWeChatAppSecret(String appSecret){
        LATTE_CONFIGS.put(ConfigKeys.WE_CHAT_APP_SECRET, appSecret);
        return this;
    }

    public final Configurator withActivity(Activity activity){
        LATTE_CONFIGS.put(ConfigKeys.ACTIVITY, activity);
        return this;
    }

    private void initIcons(){
        if (ICONS.size() > 0) {
            // 第一个用来初始化了
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }
}
