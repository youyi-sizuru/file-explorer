package com.kami.fileexplorer.ui.file;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.kami.fileexplorer.R;
import com.kami.fileexplorer.ui.BaseActivity;
import com.kami.fileexplorer.widget.FSRecyclerView;

import butterknife.BindView;

/**
 * author: youyi_sizuru
 * data: 2017/7/16
 */

public class FileActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.file_route_list)
    FSRecyclerView mFileRouteListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_file);
        setSupportActionBar(mToolbar);
        initFileRouteListView();
    }
    private void initFileRouteListView(){
        mFileRouteListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }
}
