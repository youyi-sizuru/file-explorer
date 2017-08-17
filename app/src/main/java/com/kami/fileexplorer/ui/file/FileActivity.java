package com.kami.fileexplorer.ui.file;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kami.fileexplorer.R;
import com.kami.fileexplorer.bean.FileRoute;
import com.kami.fileexplorer.data.FileExplorer;
import com.kami.fileexplorer.ui.BaseActivity;
import com.kami.fileexplorer.ui.BaseAdapter;
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
    private FileFragment mFileFragment;


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
        FileExplorer fileExplorer = (FileExplorer) getIntent().getSerializableExtra(FILE_EXPLORER);
        getSupportActionBar().setTitle(fileExplorer.getTitle());
        mFileFragment = (FileFragment) getSupportFragmentManager().findFragmentById(R.id.file_fragment);
        initFragment(fileExplorer);
    }

    private void initFragment(FileExplorer fileExplorer) {
        FilePresenter presenter = new FilePresenter(mFileFragment, fileExplorer);
        mFileFragment.setPresenter(presenter);
    }

    @Override
    public void onBackPressed() {
       if(!mFileFragment.backTo()){
           super.onBackPressed();
       }
    }
}
