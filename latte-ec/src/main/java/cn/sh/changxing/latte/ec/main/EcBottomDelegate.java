package cn.sh.changxing.latte.ec.main;

import android.graphics.Color;

import java.util.LinkedHashMap;

import cn.sh.changxing.latte.delegates.bottom.BaseBottomDelegate;
import cn.sh.changxing.latte.delegates.bottom.BottomItemDelegate;
import cn.sh.changxing.latte.delegates.bottom.BottomTabBean;
import cn.sh.changxing.latte.delegates.bottom.ItemBuilder;
import cn.sh.changxing.latte.ec.main.index.IndexDelegate;
import cn.sh.changxing.latte.ec.main.sort.SortDelegate;

/**
 * Created by ZengChao on 2018/2/23.
 */

public class EcBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}","主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}","分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}","发现"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}","购物车"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}","我的"), new IndexDelegate());
        return items;
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
