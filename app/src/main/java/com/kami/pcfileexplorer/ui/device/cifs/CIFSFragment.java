package com.kami.pcfileexplorer.ui.device.cifs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kami.pcfileexplorer.R;
import com.kami.pcfileexplorer.bean.CIFSDevice;
import com.kami.pcfileexplorer.ui.BaseFragment;
import com.kami.pcfileexplorer.widget.FSRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * author: youyi_sizuru
 * data: 2017/6/17
 */

public class CIFSFragment extends BaseFragment implements CIFSContract.View {
    private CIFSContract.Presenter mPresenter;
    @BindView(R.id.cifs_list)
    FSRecyclerView mCifsListView;
    private CIFSListAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_cifs, container, false);
    }


    @Nullable
    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public void setCifsList(List<CIFSDevice> deviceList) {
        mAdapter.setList(deviceList);
    }


    @Override
    public void notifyError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new CIFSListAdapter(getContext());
        mCifsListView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        mCifsListView.setAdapter(mAdapter);
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(CIFSContract.Presenter presenter) {
        this.mPresenter = presenter;
    }


    @Override
    public void onDestroyView() {
        mPresenter.unSubscribe();
        super.onDestroyView();
    }

}
