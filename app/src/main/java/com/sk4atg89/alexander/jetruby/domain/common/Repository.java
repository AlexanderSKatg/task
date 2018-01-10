package com.sk4atg89.alexander.jetruby.domain.common;

import io.reactivex.Single;

public interface Repository<R> {
    Single<R> get(int page);
}
