package com.sk4atg89.alexander.jetruby.presentation.content;

import com.sk4atg89.alexander.jetruby.R;
import com.sk4atg89.alexander.jetruby.di.activity.ActivityScope;
import com.sk4atg89.alexander.jetruby.presentation.base.BaseRouter;
import com.sk4atg89.alexander.jetruby.presentation.content.fragment.ImagesFragment;

import javax.inject.Inject;

@ActivityScope
public class DribbbleImagesRouter extends BaseRouter {

    @Inject
    DribbbleImagesRouter(DribbbleImagesActivity activity) {
        super(activity.getSupportFragmentManager());
    }

    void openImagesFragment() {
        replaceFragment(R.id.container, ImagesFragment.newInstance(), ImagesFragment.class.getSimpleName());
    }
}
