package cn.sh.changxing.latte.ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * Created by ZengChao on 2018/2/28.
 */

@AutoValue
public abstract class RgbValue {
    public abstract int red();

    public abstract int green();

    public abstract int blue();

    public static RgbValue create(int red, int green, int blue) {
        return new AutoValue_RgbValue(red, green, blue);
    }
}
