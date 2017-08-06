package com.kami.fileexplorer.ui.file;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kami.fileexplorer.R;
import com.kami.fileexplorer.data.FileExplorer;
import com.kami.fileexplorer.ui.BaseAdapter;
import com.kami.fileexplorer.ui.BaseFragment;
import com.kami.fileexplorer.widget.FSRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * author: youyi_sizuru
 * data: 2017/7/23
 */

public class FileFragment extends BaseFragment implements FileContract.View, BaseAdapter.OnItemClickListener {
    private static final String PATH = "path";
    private FileContract.Presenter mPresenter;
    @BindView(R.id.file_list)
    FSRecyclerView mFileListView;
    private FileAdapter mFileAdapter;
    private String mPath;

    public static FileFragment newInstance(String path) {
        FileFragment fileFragment = new FileFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PATH, path);
        fileFragment.setArguments(bundle);
        return fileFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mPath = bundle.getString(PATH);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_file, container, false);
    }

    @Override
    public void setPresenter(FileContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFileListView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mFileAdapter = new FileAdapter(getContext());
        mFileAdapter.setItemClickListener(this);
        mFileListView.setAdapter(mFileAdapter);
        mPresenter.subscribe();
    }

    @Override
    public void onItemClick(BaseAdapter adapter, int position, View view) {
        FileExplorer.File file = mFileAdapter.getList().get(position);
        if (file.isDirectory()) {
            FileActivity activity = (FileActivity) getActivity();
            activity.openDirectory(mPath + "/" + file.getName(), file.getName());
        }
    }

    @Override
    public void listFile(List<FileExplorer.File> fileList) {
        mFileAdapter.setList(fileList);
    }

    @Override
    public String getPath() {
        return mPath;
    }

    @Override
    public void notifyError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        mPresenter.unSubscribe();
        super.onDestroyView();
    }
}
