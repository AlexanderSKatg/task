package com.sk4atg89.alexander.jetruby.presentation.content.fragment;

import com.sk4atg89.alexander.jetruby.domain.common.DribbbleEntity;
import com.sk4atg89.alexander.jetruby.domain.images.ImagesInteractor;
import com.sk4atg89.alexander.jetruby.presentation.base.BasePresenter;
import com.sk4atg89.alexander.jetruby.presentation.common.DribbbleErrorHandler;
import com.sk4atg89.alexander.jetruby.utils.RxComposeSheduler;
import com.sk4atg89.alexander.jetruby.utils.RxManage;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ImagesPresenter implements BasePresenter<ImagesContract.View>, ImagesContract.EventListener {

    private ImagesContract.View mView;
    private ImagesInteractor mImagesInteractor;
    private DribbbleErrorHandler mErrorHandler;
    private int mCount;

    @Inject
    ImagesPresenter(DribbbleErrorHandler errorHandler
            , ImagesInteractor imagesInteractor) {
        mImagesInteractor = imagesInteractor;
        mErrorHandler = errorHandler;
    }

    @Override
    public void attachView(ImagesContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        RxManage.unsubscribe(this);
        mView = null;
    }

    @Override
    public void getImages(int page) {
        RxManage.manage(this, mImagesInteractor.getImages(page)
                .flatMapObservable(Observable::fromIterable)
                .filter(DribbbleEntity::imageNotNull)
                .filter(dribbbleEntity -> checkCount())
                .toList()
                .compose(RxComposeSheduler.applySchedulersSingle())
                .doOnSubscribe(disposable -> mView.refresh(true))
                .doAfterTerminate(() -> mView.refresh(false))
                .subscribe(dribbbleEntities -> {
                    mView.handleVisibility(dribbbleEntities == null || dribbbleEntities.isEmpty());
                    mView.showImages(dribbbleEntities);
                }, throwable -> mErrorHandler.handleError(throwable, info -> mView.showMessage(info))));
    }

    void reset() {
        mCount = 0;
    }

    private boolean checkCount() {
        return mCount++ < 50;
    }
}
