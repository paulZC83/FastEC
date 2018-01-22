package cn.sh.changxing.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by ZengChao on 2018/1/19.
 */

public enum EcIcons implements Icon{
    // 把阿里巴巴矢量图标库中相应的图标的代码的"&#x"改为“右斜杠u”
    icon_test_1('\ue635'),
    icon_test_2('\ue738');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
