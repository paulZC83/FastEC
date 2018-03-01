package cn.sh.changxing.latte.ec.main.sort.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.sh.changxing.latte.delegates.LatteDelegate;
import cn.sh.changxing.latte.ec.R;

/**
 * Created by ZengChao on 2018/3/1.
 */

public class VerticalListDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_vertical_list;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
