package com.sk4atg89.alexander.jetruby.presentation.content;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sk4atg89.alexander.jetruby.R;
import com.sk4atg89.alexander.jetruby.presentation.base.BaseActivity;

import javax.inject.Inject;

public class DribbbleImagesActivity extends BaseActivity {

    @Inject
    DribbbleImagesRouter mRouter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dribbble_images);

        mRouter.openImagesFragment();

    }

}
