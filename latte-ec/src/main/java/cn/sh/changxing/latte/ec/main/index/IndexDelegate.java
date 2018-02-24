package cn.sh.changxing.latte.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.sh.changxing.latte.delegates.bottom.BottomItemDelegate;
import cn.sh.changxing.latte.ec.R;

/**
 * Created by ZengChao on 2018/2/23.
 */

public class IndexDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
