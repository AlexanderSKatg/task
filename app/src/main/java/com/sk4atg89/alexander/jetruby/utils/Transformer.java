package com.sk4atg89.alexander.jetruby.utils;

public interface Transformer<F, T> {
    T transform(F from);
}
