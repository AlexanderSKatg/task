package com.sk4atg89.alexander.jetruby.domain.images;

import com.sk4atg89.alexander.jetruby.domain.common.DribbbleEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class ImagesInteractor {

    private ImagesRepository mImagesRepository;
    private int mCount;

    @Inject
    ImagesInteractor(ImagesRepository imagesRepository) {
        this.mImagesRepository = imagesRepository;
    }

    public Single<List<DribbbleEntity>> getImages(int page) {
        return mImagesRepository.get(page)
                .doOnSubscribe(disposable -> reset(page))
                .flatMapObservable(Observable::fromIterable)
                .filter(DribbbleEntity::imageNotNull)
                .filter(dribbbleEntity -> checkCount())
                .toList();
    }

    private void reset(int page) {
        if (page == 0) mCount = 0;
    }


    private boolean checkCount() {
        return mCount++ < 50;
    }
}
