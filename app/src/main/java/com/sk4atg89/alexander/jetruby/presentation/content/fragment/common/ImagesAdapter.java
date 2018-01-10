package com.sk4atg89.alexander.jetruby.presentation.content.fragment.common;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sk4atg89.alexander.jetruby.R;
import com.sk4atg89.alexander.jetruby.domain.common.DribbbleEntity;
import com.sk4atg89.alexander.jetruby.presentation.content.fragment.ImagesContract;

import java.util.ArrayList;
import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesHolder> {

    private List<DribbbleEntity> mImages;
    private ImagesContract.EventListener mListener;
    private int mPage;

    public ImagesAdapter(ImagesContract.EventListener listener) {
        this.mListener = listener;
    }

    @Override
    public ImagesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImagesHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dribbble_image, parent, false));
    }

    @Override
    public void onBindViewHolder(ImagesHolder holder, int position) {
        holder.setup(mImages.get(position));
        if (mImages != null && position == mImages.size() - 1 && mImages.size() < 50) {
            mListener.getImages(++mPage);
        }
    }

    @Override
    public int getItemCount() {
        return mImages == null ? 0 : mImages.size();
    }

    public void updateImages(List<DribbbleEntity> images) {
        if (mImages == null) {
            mImages = new ArrayList<>();
        }

        mImages.addAll(images);
        notifyItemRangeInserted(mImages.size(), images.size());
    }

    public void resetPage() {
        mImages = new ArrayList<>();
        notifyDataSetChanged();
        mPage = 0;
    }
}
