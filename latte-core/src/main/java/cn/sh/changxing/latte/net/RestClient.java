package cn.sh.changxing.latte.net;

import android.content.Context;

import java.io.File;
import java.util.WeakHashMap;

import cn.sh.changxing.latte.net.callback.IError;
import cn.sh.changxing.latte.net.callback.IFailure;
import cn.sh.changxing.latte.net.callback.IRequest;
import cn.sh.changxing.latte.net.callback.IRequestCallbacks;
import cn.sh.changxing.latte.net.callback.ISuccess;
import cn.sh.changxing.latte.net.download.DownloadHandler;
import cn.sh.changxing.latte.ui.LatteLoader;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
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
    private final File FILE;
    private final Context CONTEXT;
    private final String LOADER_STYLE;
    // 下载文件目录
    private final String DOWNLOAD_DIR;
    // 下载文件后缀
    private final String EXTENSION;
    // 下载文件名(需要完整路径,和上面的目录及后缀二选一使用)
    private final String NAME;

    public RestClient(String url, WeakHashMap<String, Object> params, ISuccess success,
                      IError error, IFailure failure, IRequest request, RequestBody body,
                      File file, Context context, String loaderStyle, String downloadDir,
                      String extension, String name) {
        this.URL = url;
        PARAMS.putAll(params);
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.REQUEST = request;
        this.BODY = body;
        this.FILE = file;
        this.CONTEXT = context;
        this.LOADER_STYLE = loaderStyle;
        this.DOWNLOAD_DIR = downloadDir;
        this.EXTENSION = extension;
        this.NAME = name;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }
        if (LOADER_STYLE != null) {
            LatteLoader.showLoading(CONTEXT, LOADER_STYLE);
        }
        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case POST_RAW:
                call = service.postRaw(URL, BODY);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case PUT_RAW:
                call = service.putRaw(URL, BODY);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody = RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                MultipartBody.Part part = MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                call = service.upload(URL, part);
                break;
            default:
                break;
        }
        if (call != null) {
            call.enqueue(getRequestCallback());
        }

    }

    private Callback<String> getRequestCallback() {
        return new IRequestCallbacks(SUCCESS, ERROR, FAILURE, REQUEST, LOADER_STYLE);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        if (BODY == null) {
            request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.POST_RAW);
        }

    }

    public final void put() {
        if (BODY == null) {
            request(HttpMethod.PUT);
        } else {
            if (PARAMS != null) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.PUT_RAW);
        }
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }

    public final void download(){
        new DownloadHandler(URL,SUCCESS,ERROR,FAILURE,REQUEST,DOWNLOAD_DIR,EXTENSION,NAME).handleDownload();
    }
}
