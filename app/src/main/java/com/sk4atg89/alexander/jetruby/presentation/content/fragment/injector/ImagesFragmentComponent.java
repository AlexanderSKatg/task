package com.sk4atg89.alexander.jetruby.presentation.content.fragment.injector;


import com.sk4atg89.alexander.jetruby.di.fragment.FragmentScope;
import com.sk4atg89.alexander.jetruby.presentation.content.fragment.ImagesFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent
public interface ImagesFragmentComponent extends AndroidInjector<ImagesFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ImagesFragment> {
    }

//    @Module
//    class ImagesModule {
//        @Provides
//        ImagesContract.EventDelegate provideRouter(DribbbleImagesRouter router) {
//            return router;
//        }
//    }

}
