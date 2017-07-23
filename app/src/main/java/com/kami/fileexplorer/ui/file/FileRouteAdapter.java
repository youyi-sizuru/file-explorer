package com.kami.fileexplorer.ui.file;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.kami.fileexplorer.bean.FileRoute;
import com.kami.fileexplorer.ui.BaseAdapter;

import java.util.List;

/**
 * author: youyi_sizuru
 * data: 2017/7/23
 */

class FileRouteAdapter extends BaseAdapter<FileRoute, FileRouteAdapter.FileRouteViewHolder> {


    public FileRouteAdapter(@NonNull Context context, @Nullable List<FileRoute> list) {
        super(context, list);
    }

    @Override
    public FileRouteViewHolder onCreateBaseViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

   final static class FileRouteViewHolder extends BaseAdapter.BaseViewHolder<FileRoute> {
        public FileRouteViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void updateViewData(FileRoute item) {

        }
    }
}
