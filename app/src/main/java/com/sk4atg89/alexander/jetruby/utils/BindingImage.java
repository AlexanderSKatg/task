package com.sk4atg89.alexander.jetruby.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sk4atg89.alexander.jetruby.Constant;
import com.sk4atg89.alexander.jetruby.presentation.common.GlideDribbble;

public class BindingImage {

    @BindingAdapter({"image"})
    public static void bindImage(ImageView view, Object url) {

        GlideDribbble.with(view)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .override(view.getWidth(), Constant.SCREEN_HALF_HEIGHT)
                .into(view);

    }

}
