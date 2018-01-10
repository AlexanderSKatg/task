package com.sk4atg89.alexander.jetruby.presentation.common;


import com.sk4atg89.alexander.jetruby.data.common.FakeException;

import javax.inject.Inject;

public class DribbbleErrorHandler implements ErrorHandler {

    @Inject
    public DribbbleErrorHandler() {
    }

    @Override
    public void handleError(Throwable throwable, ErrorToView view) {

        String text = "Something went wrong";

        if (throwable instanceof FakeException) {
            text = throwable.getMessage();
        }

        view.showMessage(text);
    }
}
