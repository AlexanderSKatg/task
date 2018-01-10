package com.sk4atg89.alexander.jetruby.utils;


import java.util.HashMap;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxManage {

    private static final HashMap<Object, CompositeDisposable> sDisposables = new HashMap<>();

    public static void manage(Object tag, Disposable disposable) {
        CompositeDisposable disposables = sDisposables.get(tag);
        if (disposables == null) {
            disposables = new CompositeDisposable();
            sDisposables.put(tag, disposables);
        }

        disposables.add(disposable);
    }

    public static void unsubscribe(Object tag) {
        CompositeDisposable disposables = sDisposables.get(tag);
        if (disposables != null) {
            disposables.dispose();
            sDisposables.remove(tag);
        }
    }

}
