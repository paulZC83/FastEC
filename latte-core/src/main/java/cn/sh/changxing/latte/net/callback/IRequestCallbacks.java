package cn.sh.changxing.latte.net.callback;


import android.os.Handler;
import android.util.Log;

import cn.sh.changxing.latte.ui.LatteLoader;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ZengChao on 2018/1/24.
 */

public class IRequestCallbacks implements Callback<String> {
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    private final IRequest REQUEST;
    private final String LOADER_STYLE;
    private final Handler mHandler = new Handler();// 测试用，用于延迟2s关闭dialog

    public IRequestCallbacks(ISuccess success, IError error, IFailure failure, IRequest request, String loaderStyle) {
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.REQUEST = request;
        this.LOADER_STYLE = loaderStyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }
        if (LOADER_STYLE != null) {
            // 为了测试延迟关闭dialog
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LatteLoader.stopLoading();
                }
            }, 2000);

        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        Log.d("Callbacks-------", t.getMessage());
        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }
        if (LOADER_STYLE != null) {
            LatteLoader.stopLoading();
        }
    }

}
