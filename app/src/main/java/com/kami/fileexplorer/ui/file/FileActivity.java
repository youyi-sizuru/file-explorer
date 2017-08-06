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

public class FileActivity extends BaseActivity implements BaseAdapter.OnItemClickListener {

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
        openDirectory("", mFileExplorer.getDeviceName());
    }

    private void initFileRouteListView() {
        mFileRouteListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<FileRoute> list = new ArrayList<>();
        list.add(new FileRoute(mFileExplorer.getTitle(), mFileExplorer.getTitle()));
        mFileRouteAdapter = new FileRouteAdapter(this, list);
        mFileRouteAdapter.setItemClickListener(this);
        mFileRouteListView.setAdapter(mFileRouteAdapter);
    }


    @Override
    public void onItemClick(BaseAdapter adapter, int position, View view) {
        if (position > 0) {
            String tag = mFileRouteAdapter.getList().get(position).getTag();
            boolean pop = getSupportFragmentManager().popBackStackImmediate(tag, 0);
            if (pop) {
                mFileRouteAdapter.removeTo(position);
            }
        } else {
            finish();
        }
    }

    void openDirectory(String path, String name) {
        String tag = "file://" + path;
        mFileRouteAdapter.add(new FileRoute(name, tag));
        mFileRouteListView.scrollToPosition(mFileRouteAdapter.getItemCount() - 1);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FileFragment fragment = FileFragment.newInstance(path);
        FilePresenter presenter = new FilePresenter(fragment, mFileExplorer);
        fragment.setPresenter(presenter);
        transaction.add(R.id.fragment_container, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 1 && fragmentManager.popBackStackImmediate()) {
            mFileRouteAdapter.remove();
        } else {
            finish();
        }
    }
}
