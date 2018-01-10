package com.sk4atg89.alexander.jetruby.data.dribbble;

import com.sk4atg89.alexander.jetruby.data.common.DribbbleImage;
import com.sk4atg89.alexander.jetruby.data.network.DribbbleService;
import com.sk4atg89.alexander.jetruby.data.network.dto.DribbbleDTO;
import com.sk4atg89.alexander.jetruby.data.network.dto.ImageDTO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class DribbbleRemote {

    private DribbbleDBManager mDribbbleDBManager;
    private DribbbleService mDribbbleService;
    private final static String accessToken = "6ed972085fecb7078ef53a3056562c05de38514ebd7d095b6a84f6dba7743031";
    private final static int PER_PAGE = 10;

    @Inject
    DribbbleRemote(DribbbleDBManager dribbbleDBManager
            , DribbbleService dribbbleService) {
        mDribbbleDBManager = dribbbleDBManager;
        mDribbbleService = dribbbleService;
    }

    Single<List<DribbbleImage>> getImages(int page) {
        return mDribbbleService.getShots(accessToken, page, PER_PAGE)
                .flatMapObservable(Observable::fromIterable)
                .filter(dribbbleDTO -> !dribbbleDTO.animated)
                .toList()
                .map(this::map)
                .doOnSuccess(dribbbleImages -> mDribbbleDBManager.saveImages(dribbbleImages));
    }

    private List<DribbbleImage> map(List<DribbbleDTO> dtos) {
        List<DribbbleImage> images = new ArrayList<>();
        int size = dtos.size();
        for (int i = 0; i < size; i++) {
            images.add(map(dtos.get(i)));
        }
        return images;
    }

    private DribbbleImage map(DribbbleDTO dto) {
        DribbbleImage dribbbleImage = new DribbbleImage();
        dribbbleImage.setImageUrl(getImageUrl(dto.images));
        dribbbleImage.setTitle(dto.title);
        dribbbleImage.setDescribtion(dto.description);
        return dribbbleImage;

    }

    private String getImageUrl(ImageDTO urls) {
        return urls.hidpi != null ? urls.hidpi : urls.normal
                != null ? urls.normal : urls.teaser;
    }
}
