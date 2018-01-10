package com.sk4atg89.alexander.jetruby.presentation.content.fragment.common;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sk4atg89.alexander.jetruby.databinding.ItemDribbbleImageBinding;
import com.sk4atg89.alexander.jetruby.domain.common.DribbbleEntity;

class ImagesHolder extends RecyclerView.ViewHolder {

    private ItemDribbbleImageBinding mBinding;

    ImagesHolder(View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }

    void setup(DribbbleEntity dribbbleEntity) {
        mBinding.setItem(dribbbleEntity);
    }
}
