package cn.sh.changxing.latte.ui.recycler;

import android.support.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * Created by ZengChao on 2018/2/28.
 */

public class BaseDecoration extends DividerItemDecoration {//继承第三方库的DividerItemDecoration
    private BaseDecoration(@ColorInt int color, int size) {
        setDividerLookup(new DividerLookupImpl(color, size));
    }

    public static BaseDecoration create(@ColorInt int color, int size){
        return new BaseDecoration(color,size);
    }
}
