package cn.sh.changxing.latte.ui.banner;

import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.util.ArrayList;

import cn.sh.changxing.latte.R;

/**
 * Created by ZengChao on 2018/2/27.
 */

public class BannerCreator {

    public static void setDefault(ConvenientBanner<String> convenientBanner, ArrayList<String> banner,
                                  OnItemClickListener clickListener){
        convenientBanner.setPages(new HolderCreator(), banner)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
        .setOnItemClickListener(clickListener)
        .setPageTransformer(new DefaultTransformer())
        .startTurning(3000)
        .setCanLoop(true);
    }
}
