package cn.sh.changxing.latte.net;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import cn.sh.changxing.latte.app.ConfigType;
import cn.sh.changxing.latte.app.Latte;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ZengChao on 2018/1/23.
 */

public class RestCreator {

    private static final class ParamsHolder{
        private static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams(){
        return ParamsHolder.PARAMS;
    }

    public static RestService getRestService(){
        return RestServiceHolder.REST_SERVICE;
    }

    public static final class RetrofitHolder {
        private static final String BASE_URL = (String) Latte.getConfigurations()
                .get(ConfigType.API_HOST.name());
        private static final Retrofit RETROFIT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(OkhttpHolder.OK_HTTP_CLIENT)
                .build();
    }

    public static final class OkhttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    public static final class RestServiceHolder {
        private static final RestService REST_SERVICE = RetrofitHolder.RETROFIT
                .create(RestService.class);
    }
}
