package cn.sh.changxing.latte.ec.main.sort.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.sh.changxing.latte.delegates.LatteDelegate;
import cn.sh.changxing.latte.ec.R;

/**
 * Created by ZengChao on 2018/3/1.
 */

public class ContentDelegate extends LatteDelegate {
    private static final String ARG_CONTENT_ID = "CONTENT_ID";
    private int mContentId = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args != null) {
            mContentId = args.getInt(ARG_CONTENT_ID);
        }
    }

    public static ContentDelegate newInstance(int contentId) {
        final Bundle args = new Bundle();
        args.putInt(ARG_CONTENT_ID, contentId);
        final ContentDelegate delegate = new ContentDelegate();
        delegate.setArguments(args);
        return delegate;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_list_content;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
