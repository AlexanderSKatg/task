package com.sk4atg89.alexander.jetruby.presentation.content.fragment;


import com.sk4atg89.alexander.jetruby.domain.common.DribbbleEntity;
import com.sk4atg89.alexander.jetruby.presentation.base.BaseView;

import java.util.List;

public interface ImagesContract {

    interface EventListener {
        void getImages(int page);
    }

    interface View extends BaseView {
        void showImages(List<DribbbleEntity> images);
        void refresh(boolean refresh);

        void handleVisibility(boolean b);
    }

}
