package com.kami.fileexplorer.ui.file;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kami.fileexplorer.ui.BaseFragment;

/**
 * author: youyi_sizuru
 * data: 2017/7/23
 */

public class FileFragment extends BaseFragment implements FileContract.View {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setPresenter(FileContract.Presenter presenter) {

    }
}
