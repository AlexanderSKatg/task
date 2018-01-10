package com.sk4atg89.alexander.jetruby.presentation.content;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.sk4atg89.alexander.jetruby.di.activity.ActivityScope;
import com.sk4atg89.alexander.jetruby.presentation.content.fragment.ImagesFragment;
import com.sk4atg89.alexander.jetruby.presentation.content.fragment.injector.ImagesFragmentComponent;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@ActivityScope
@Subcomponent(modules = {
        DribbbleImagesComponent.DribbbleModule.class
        , DribbbleImagesComponent.FragmentBindingsModule.class
})
public interface DribbbleImagesComponent extends AndroidInjector<DribbbleImagesActivity>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DribbbleImagesActivity> {
    }

    @Module
    class DribbbleModule {
        @Provides
        Activity provideActivity(DribbbleImagesActivity activity) {
            return activity;
        }
    }

    @Module(subcomponents = {ImagesFragmentComponent.class})
    abstract class FragmentBindingsModule {
        @Binds
        @FragmentKey(ImagesFragment.class)
        @IntoMap
        public abstract AndroidInjector.Factory<? extends Fragment> provideTeamsFragmentComponentBuilder(ImagesFragmentComponent.Builder builder);
    }
}
