package com.kami.fileexplorer.ui.file;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.kami.fileexplorer.R;
import com.kami.fileexplorer.bean.FileRoute;
import com.kami.fileexplorer.data.FileExplorer;
import com.kami.fileexplorer.ui.BaseActivity;
import com.kami.fileexplorer.widget.FSRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author: youyi_sizuru
 * data: 2017/7/16
 */

public class FileActivity extends BaseActivity {

    private static final String FILE_EXPLORER = "file_explorer";
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.file_route_list)
    FSRecyclerView mFileRouteListView;
    private FileRouteAdapter mFileRouteAdapter;
    private FileExplorer mFileExplorer;


    public static Intent getIntent(Context context, FileExplorer explorer) {
        Intent intent = new Intent(context, FileActivity.class);
        intent.putExtra(FILE_EXPLORER, explorer);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_file);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mFileExplorer = (FileExplorer) getIntent().getSerializableExtra(FILE_EXPLORER);
        getSupportActionBar().setTitle(mFileExplorer.getTitle());
        initFileRouteListView();

    }

    private void initFileRouteListView() {
        mFileRouteListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<FileRoute> list = new ArrayList<>();
        list.add(new FileRoute(mFileExplorer.getTitle(), mFileExplorer.getTitle()));
        list.add(new FileRoute(mFileExplorer.getDeviceName(),mFileExplorer.getDeviceName()));
        mFileRouteAdapter = new FileRouteAdapter(this, list);
        mFileRouteListView.setAdapter(mFileRouteAdapter);
    }
}
