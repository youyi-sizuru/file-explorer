package com.kami.fileexplorer.ui.file;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.kami.fileexplorer.R;
import com.kami.fileexplorer.ui.BaseActivity;
import com.kami.fileexplorer.widget.FSRecyclerView;

import butterknife.BindView;

/**
 * author: youyi_sizuru
 * data: 2017/7/16
 */

public class FileActivity extends BaseActivity implements FileContract.View {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.file_list)
    FSRecyclerView mFileListView;

    private FileContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_file);
        setSupportActionBar(mToolbar);
        setPresenter(new FilePresenter(this));
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(FileContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    protected void onDestroy() {
        mPresenter.unSubscribe();
        super.onDestroy();
    }
}
