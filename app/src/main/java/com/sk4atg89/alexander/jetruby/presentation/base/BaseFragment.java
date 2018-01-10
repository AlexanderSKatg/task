package com.sk4atg89.alexander.jetruby.presentation.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment extends Fragment implements BaseView {

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }
}
