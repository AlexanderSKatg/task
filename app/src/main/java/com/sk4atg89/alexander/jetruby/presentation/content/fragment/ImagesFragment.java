package com.sk4atg89.alexander.jetruby.presentation.content.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sk4atg89.alexander.jetruby.R;
import com.sk4atg89.alexander.jetruby.databinding.FragmentImagesBinding;
import com.sk4atg89.alexander.jetruby.domain.common.DribbbleEntity;
import com.sk4atg89.alexander.jetruby.presentation.base.BaseFragment;
import com.sk4atg89.alexander.jetruby.presentation.content.fragment.common.ImagesAdapter;

import java.util.List;

import javax.inject.Inject;

public class ImagesFragment extends BaseFragment implements ImagesContract.View {

    @Inject
    ImagesPresenter mPresenter;

    private FragmentImagesBinding mBinding;
    private ImagesAdapter mAdapter;

    public static ImagesFragment newInstance() {
        return new ImagesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_images, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
        mPresenter.getImages(0);
        mBinding.swipeRefreshLayout.setOnRefreshListener(() -> {
            mPresenter.reset();
            mPresenter.getImages(0);
            mAdapter.resetPage();
        });
        mBinding.rImages.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.rImages.setAdapter(mAdapter = new ImagesAdapter(mPresenter));
    }

    @Override
    public void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showImages(List<DribbbleEntity> images) {
        mAdapter.updateImages(images);
    }

    @Override
    public void handleVisibility(boolean b) {
        mBinding.tvNoImages.setVisibility(b ? View.VISIBLE : View.GONE);
    }

    @Override
    public void refresh(boolean refresh) {
        mBinding.swipeRefreshLayout.setRefreshing(refresh);
    }
}
