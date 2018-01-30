package cn.sh.changxing.latte.net.interceptors;

import android.support.annotation.RawRes;

import java.io.IOException;

import cn.sh.changxing.latte.utils.file.FileUtil;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by ZengChao on 2018/1/29.
 */

public class DebugInterceptor extends BaseInterceptor {
    private final String DEBUG_URL;
    private final int RAW_ID;

    public DebugInterceptor(String debugUrl, int rawId) {
        this.DEBUG_URL = debugUrl;
        this.RAW_ID = rawId;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final String url = chain.request().url().toString();
        if (url.contains(DEBUG_URL)) {
            return debugResponse(chain, RAW_ID);
        }
        return chain.proceed(chain.request());
    }

    private Response getResponse(Chain chain, String json) {
        return new Response.Builder()
                .code(200) // 200表示成功
                .message("OK")
                .addHeader("Content-Type","application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"),json))
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .build();
    }

    private Response debugResponse(Chain chain, @RawRes int rawId) {
        String json = FileUtil.getRawFile(rawId);
        return getResponse(chain, json);
    }
}
