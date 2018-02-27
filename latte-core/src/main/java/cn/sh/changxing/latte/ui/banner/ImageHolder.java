package cn.sh.changxing.latte.ui.banner;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by ZengChao on 2018/2/27.
 */

public class ImageHolder implements Holder<String>{
    private AppCompatImageView mImageView = null;

    @Override
    public View createView(Context context) {
        mImageView = new AppCompatImageView(context);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        Glide.with(context)
                .load(data)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .centerCrop()
                .into(mImageView);
    }
}
