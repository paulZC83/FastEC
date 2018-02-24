package cn.sh.changxing.latte.delegates.bottom;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import cn.sh.changxing.latte.R;
import cn.sh.changxing.latte.delegates.LatteDelegate;

/**
 * Created by ZengChao on 2018/2/23.
 */

public abstract class BottomItemDelegate extends LatteDelegate implements View.OnKeyListener {
    private final long EXIT_TIME = 2000;
        private long mExitTime = 0;

    @Override
    public void onResume() {
        super.onResume();
        final View rootView = getView();
        if (rootView != null) {
            rootView.setFocusableInTouchMode(true);
            rootView.requestFocus();
            rootView.setOnKeyListener(this);
        }
    }

    @Override
    public boolean onKey(View view, int code, KeyEvent keyEvent) {
        if (code == KeyEvent.KEYCODE_BACK && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - mExitTime > EXIT_TIME) {
                Toast.makeText(getContext(), "再按一次退出"+getString(R.string.app_name), Toast.LENGTH_LONG).show();
                mExitTime = System.currentTimeMillis();
            } else {
                _mActivity.finish();
                if (mExitTime != 0) {
                    mExitTime = 0;
                }
            }
            return true;
        }
        return false;
    }
}
