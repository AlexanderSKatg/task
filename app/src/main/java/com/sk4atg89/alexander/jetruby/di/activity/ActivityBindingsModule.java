package com.sk4atg89.alexander.jetruby.di.activity;

import android.app.Activity;

import com.sk4atg89.alexander.jetruby.presentation.content.DribbbleImagesActivity;
import com.sk4atg89.alexander.jetruby.presentation.content.DribbbleImagesComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector.Factory;
import dagger.multibindings.IntoMap;

@Module(subcomponents = DribbbleImagesComponent.class)
public abstract class ActivityBindingsModule {

    @Binds
    @IntoMap
    @ActivityKey(DribbbleImagesActivity.class)
    public abstract Factory<? extends Activity> dribbbleActivityComponentBuilder(DribbbleImagesComponent.Builder builder);

}