package com.sk4atg89.alexander.jetruby.data.dribbble;

import com.sk4atg89.alexander.jetruby.data.common.DribbbleImagesTransformer;
import com.sk4atg89.alexander.jetruby.domain.common.DribbbleEntity;
import com.sk4atg89.alexander.jetruby.domain.images.ImagesRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class DribbbbleImagesRepository implements ImagesRepository {

    private DribbbleDBManager mDribbbleDBManager;
    private DribbbleRemote mDribbbleRemote;
    private DribbbleImagesTransformer mDribbbleImagesTransformer;

    @Inject
    DribbbbleImagesRepository(DribbbleDBManager dribbbleDBManager
            , DribbbleRemote dribbbleRemote
            , DribbbleImagesTransformer dribbbleImagesTransformer) {
        mDribbbleDBManager = dribbbleDBManager;
        mDribbbleRemote = dribbbleRemote;
        mDribbbleImagesTransformer = dribbbleImagesTransformer;
    }

    @Override
    public Single<List<DribbbleEntity>> get(int page) {
        return mDribbbleRemote.getImages(page)
                .onErrorResumeNext(mDribbbleDBManager.getImages())
                .map(images -> mDribbbleImagesTransformer.transform(images));
    }

}
