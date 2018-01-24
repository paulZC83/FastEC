package cn.sh.changxing.fastec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import cn.sh.changxing.latte.delegates.LatteDelegate;
import cn.sh.changxing.latte.net.RestClient;
import cn.sh.changxing.latte.net.callback.IError;
import cn.sh.changxing.latte.net.callback.IFailure;
import cn.sh.changxing.latte.net.callback.ISuccess;

/**
 * Created by ZengChao on 2018/1/22.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        test();
    }

    public void test(){
        RestClient client = RestClient.builder()
                .url("http://news.baidu.com/?tn=news")
//                .params("","")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String message) {

                    }
                })
                .build();
    }
}
