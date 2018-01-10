package com.sk4atg89.alexander.jetruby.di.app;


import com.sk4atg89.alexander.jetruby.DribbbleApp;
import com.sk4atg89.alexander.jetruby.di.activity.ActivityBindingsModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AppModule.class
        , ActivityBindingsModule.class
        , AndroidSupportInjectionModule.class
        , DataModule.class
        , NetworkModule.class
})
@Singleton
interface AppComponent extends AndroidInjector<DribbbleApp> {

    @Component.Builder
    abstract class Builder extends dagger.android.AndroidInjector.Builder<DribbbleApp> {
        public abstract Builder appModule(AppModule appModule);
    }
}
