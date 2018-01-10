package com.sk4atg89.alexander.jetruby.data.common;


import com.sk4atg89.alexander.jetruby.domain.common.DribbbleEntity;
import com.sk4atg89.alexander.jetruby.utils.Transformer;

import javax.inject.Inject;

public class TransformDribbbleImages implements Transformer<DribbbleImage, DribbbleEntity> {

    @Inject
    TransformDribbbleImages() {
    }

    @Override
    public DribbbleEntity transform(DribbbleImage from) {
        return new DribbbleEntity(from.getImageUrl(), from.getTitle(), from.getDescribtion());
    }
}
