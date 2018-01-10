package com.sk4atg89.alexander.jetruby.di.app;

import com.sk4atg89.alexander.jetruby.data.dribbble.DribbbbleImagesRepository;
import com.sk4atg89.alexander.jetruby.domain.images.ImagesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class DataModule {

    @Singleton
    @Provides
    ImagesRepository provideDribbbleImagesRepository(DribbbbleImagesRepository repository) {
        return repository;
    }

}
