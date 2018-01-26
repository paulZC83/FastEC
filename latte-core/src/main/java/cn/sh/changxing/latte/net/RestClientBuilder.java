package cn.sh.changxing.latte.net;

import android.content.Context;

import java.util.WeakHashMap;

import cn.sh.changxing.latte.net.callback.IError;
import cn.sh.changxing.latte.net.callback.IFailure;
import cn.sh.changxing.latte.net.callback.IRequest;
import cn.sh.changxing.latte.net.callback.ISuccess;
import cn.sh.changxing.latte.ui.LoaderStyle;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by ZengChao on 2018/1/24.
 */

public class RestClientBuilder {
    private String mUrl = null;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private ISuccess mSuccess = null;
    private IError mError = null;
    private IFailure mFailure = null;
    private IRequest mRequest = null;
    private RequestBody mBody = null;
    private Context mContext = null;
    private String mLoaderStyle = null;

    RestClientBuilder() {

    }

    public RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public RestClientBuilder success(ISuccess success) {
        this.mSuccess = success;
        return this;
    }

    public RestClientBuilder error(IError error) {
        this.mError = error;
        return this;
    }

    public RestClientBuilder failure(IFailure failure) {
        this.mFailure = failure;
        return this;
    }

    public RestClientBuilder onRequest(IRequest request) {
        this.mRequest = request;
        return this;
    }

    public RestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
        this.mContext = context;
        this.mLoaderStyle = loaderStyle.name();
        return this;
    }

    public RestClientBuilder loader(Context context, String loaderStyle) {
        this.mContext = context;
        this.mLoaderStyle = loaderStyle;
        return this;
    }

    public RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotateIndicator.name();
        return this;
    }

    public RestClient build() {
        return new RestClient(mUrl, PARAMS, mSuccess, mError, mFailure, mRequest, mBody, mContext, mLoaderStyle);
    }
}
