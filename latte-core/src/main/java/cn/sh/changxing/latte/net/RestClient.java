package cn.sh.changxing.latte.net;

import java.util.WeakHashMap;

import cn.sh.changxing.latte.net.callback.IError;
import cn.sh.changxing.latte.net.callback.IFailure;
import cn.sh.changxing.latte.net.callback.IRequest;
import cn.sh.changxing.latte.net.callback.IRequestCallbacks;
import cn.sh.changxing.latte.net.callback.ISuccess;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by ZengChao on 2018/1/23.
 */

public class RestClient {
    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    private final IRequest REQUEST;
    private final RequestBody BODY;

    public RestClient(String url, WeakHashMap<String, Object> params, ISuccess success, IError error, IFailure failure, IRequest request, RequestBody body) {
        this.URL = url;
        PARAMS.putAll(params);
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.REQUEST = request;
        this.BODY = body;
    }

    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }

    private void request(HttpMethod method){
        RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }
        switch (method){
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
                default:
                    break;
        }
        if (call != null) {
            call.enqueue(getRequestCallback());
        }

    }

    private Callback<String> getRequestCallback(){
        return new IRequestCallbacks(SUCCESS,ERROR,FAILURE,REQUEST);
    }

    public final void get(){
        request(HttpMethod.GET);
    }

    public final void post(){
        request(HttpMethod.POST);
    }

    public final void put(){
        request(HttpMethod.PUT);
    }

    public final void delete(){
        request(HttpMethod.DELETE);
    }
}
