package cn.sh.changxing.fastec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.sh.changxing.latte.delegates.LatteDelegate;

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

    }
}
