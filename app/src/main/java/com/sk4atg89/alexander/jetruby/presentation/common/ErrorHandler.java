package com.sk4atg89.alexander.jetruby.presentation.common;


public interface ErrorHandler {

    void handleError(Throwable throwable, ErrorToView view);
}
