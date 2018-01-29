package cn.sh.changxing.latte.net.interceptors;

import java.util.LinkedHashMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;

/**
 * Created by ZengChao on 2018/1/29.
 */

public abstract class BaseInterceptor implements Interceptor {

    /*
     * 获取Get请求的参数
     */
    protected LinkedHashMap<String, String> getUrlParams(Chain chain){
        final HttpUrl httpUrl = chain.request().url();
        int size = httpUrl.pathSize();
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            params.put(httpUrl.queryParameterName(i), httpUrl.queryParameterValue(i));
        }
        return params;
    }

    protected String getUrlParams(Chain chain, String key){
        final HttpUrl httpUrl = chain.request().url();
        return httpUrl.queryParameter(key);
    }

    /*
     * 获取POST请求的参数
     */
    protected LinkedHashMap<String, String> getBodyParams(Chain chain){
        final FormBody formBody = (FormBody) chain.request().body();
        int size = formBody.size();
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            params.put(formBody.name(i), formBody.value(i));
        }
        return params;
    }

    protected String getBodyParams(Chain chain, String key){
        return getBodyParams(chain).get(key);
    }

}
