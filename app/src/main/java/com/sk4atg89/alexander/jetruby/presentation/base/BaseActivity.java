package com.sk4atg89.alexander.jetruby.presentation.base;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.sk4atg89.alexander.jetruby.Constant;
import com.sk4atg89.alexander.jetruby.utils.DensityUtils;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class BaseActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private static final int TITLE_SIZE = 48;

    @Inject
    DispatchingAndroidInjector<Fragment> mAndroidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int height_px = Resources.getSystem().getDisplayMetrics().heightPixels;
        Constant.SCREEN_HALF_HEIGHT = height_px / 2 - (int) DensityUtils.convertDpToPixel(TITLE_SIZE, this);
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mAndroidInjector;
    }
}
