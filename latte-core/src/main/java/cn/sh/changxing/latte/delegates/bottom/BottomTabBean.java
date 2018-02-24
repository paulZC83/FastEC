package cn.sh.changxing.latte.delegates.bottom;

/**
 * Created by ZengChao on 2018/2/23.
 */

public final class BottomTabBean {
    private CharSequence ICON;
    private CharSequence TITLE;

    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }
}
