package com.kami.pcfileexplorer.ui.device.cifs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kami.pcfileexplorer.R;
import com.kami.pcfileexplorer.ui.BaseFragment;
import com.kami.pcfileexplorer.widget.FSTextView;

import butterknife.BindView;

/**
 * Created by youyi on 2017/6/17.
 */

public class CIFSFragment extends BaseFragment implements CIFSContract.View {
    private CIFSContract.Presenter mPresenter;
    @BindView(R.id.test_logger)
    FSTextView mLoggerText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_cifs, container, false);
        return view;
    }


    @Nullable
    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(CIFSContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void setLoggerText(String text) {
        mLoggerText.setText(text);
    }

    @Override
    public void onDestroyView() {
        mPresenter.unSubscribe();
        super.onDestroyView();
    }

}
