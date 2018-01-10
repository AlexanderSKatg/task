package com.sk4atg89.alexander.jetruby.domain.images;

import com.sk4atg89.alexander.jetruby.domain.common.DribbbleEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class ImagesInteractor {

    private ImagesRepository mImagesRepository;

    @Inject
    ImagesInteractor(ImagesRepository imagesRepository) {
        this.mImagesRepository = imagesRepository;
    }

    public Single<List<DribbbleEntity>> getImages(int page) {
        return mImagesRepository.get(page);
    }

}
