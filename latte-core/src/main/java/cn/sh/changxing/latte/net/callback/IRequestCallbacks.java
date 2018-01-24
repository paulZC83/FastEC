package cn.sh.changxing.latte.net.callback;


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

    public IRequestCallbacks(ISuccess success, IError error, IFailure failure, IRequest request) {
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.REQUEST = request;
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
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }
    }

//    @Override
//    public void onResponse(Call call, Response<String> response) {
//        if (response.isSuccessful()) {
//            if (call.isExecuted()) {
//                if (SUCCESS != null) {
//                    SUCCESS.onSuccess(response.body());
//                }
//            }
//        }
//    }
//
//    @Override
//    public void onFailure(Call call, Throwable t) {
//
//    }
}
