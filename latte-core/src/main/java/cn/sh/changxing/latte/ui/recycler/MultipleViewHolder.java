package cn.sh.changxing.latte.ui.recycler;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by ZengChao on 2018/2/27.
 */

public class MultipleViewHolder extends BaseViewHolder {
    private MultipleViewHolder(View view) {
        super(view);
    }

    public static MultipleViewHolder create(View view){
        return new MultipleViewHolder(view);
    }
}
