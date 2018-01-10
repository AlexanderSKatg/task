package com.sk4atg89.alexander.jetruby;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import com.sk4atg89.alexander.jetruby.di.app.AppModule;
import com.sk4atg89.alexander.jetruby.di.app.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.realm.Realm;
import io.realm.RealmConfiguration.Builder;

public class DribbbleApp extends MultiDexApplication implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        Realm.setDefaultConfiguration(new Builder()
                .name(Constant.REALM_DB_NAME)
                .schemaVersion(0)
                .build());


        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .create(this)
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }
}
