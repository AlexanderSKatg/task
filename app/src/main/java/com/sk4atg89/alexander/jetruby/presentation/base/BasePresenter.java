package com.sk4atg89.alexander.jetruby.presentation.base;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

}
