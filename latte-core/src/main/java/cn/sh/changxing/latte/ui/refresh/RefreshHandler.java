package cn.sh.changxing.latte.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import cn.sh.changxing.latte.app.Latte;
import cn.sh.changxing.latte.net.RestClient;
import cn.sh.changxing.latte.net.callback.IError;
import cn.sh.changxing.latte.net.callback.IFailure;
import cn.sh.changxing.latte.net.callback.ISuccess;

/**
 * Created by ZengChao on 2018/2/24.
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {
    private final SwipeRefreshLayout REFRESH_LAYOUT;

    public RefreshHandler(SwipeRefreshLayout refresh_layout) {
        REFRESH_LAYOUT = refresh_layout;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    private void refresh(){
        REFRESH_LAYOUT.setRefreshing(true);
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里进行一些网络请求操作
                REFRESH_LAYOUT.setRefreshing(false);
            }
        },2000);
    }

    public void firstPage(String url){
        RestClient.builder()
                .url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                        Log.d("--------zzzzcc------", "success:"+response);
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.d("--------zzzzcc------", "failure");
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Log.d("--------zzzzcc------", "error:"+code+"///"+msg);
                    }
                })
                .build()
                .get();
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
