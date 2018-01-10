package com.sk4atg89.alexander.jetruby.utils;


import com.sk4atg89.alexander.jetruby.BuildConfig;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class RxEmptyAction {

    public static final Consumer<Object> NEXT = o -> {
    };

    public static final Consumer<Throwable> ERROR = t -> {
        if (BuildConfig.DEBUG) {
            t.printStackTrace();
        }
    };

    public static final Action COMPLETE = () -> {
    };

}
