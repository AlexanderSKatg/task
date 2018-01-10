package com.sk4atg89.alexander.jetruby.utils;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Transformers {

    public static <F, T> List<T> transform(@Nullable List<F> objects, Transformer<F, T> transformer) {
        if (objects == null) {
            return Collections.emptyList();
        }
        int size = objects.size();
        ArrayList<T> result = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            result.add(transformer.transform(objects.get(i)));
        }
        return result;
    }

}
