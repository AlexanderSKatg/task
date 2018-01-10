package com.sk4atg89.alexander.jetruby.data.common;


import com.sk4atg89.alexander.jetruby.domain.common.DribbbleEntity;
import com.sk4atg89.alexander.jetruby.utils.Transformer;
import com.sk4atg89.alexander.jetruby.utils.Transformers;

import java.util.List;

import javax.inject.Inject;

public class DribbbleImagesTransformer implements Transformer<List<DribbbleImage>, List<DribbbleEntity>> {

    private TransformDribbbleImages mTransformDribbbleImages;

    @Inject
    DribbbleImagesTransformer(TransformDribbbleImages transformDribbbleImages) {
        mTransformDribbbleImages = transformDribbbleImages;
    }

    @Override
    public List<DribbbleEntity> transform(List<DribbbleImage> from) {
        return Transformers.transform(from, mTransformDribbbleImages);
    }
}
