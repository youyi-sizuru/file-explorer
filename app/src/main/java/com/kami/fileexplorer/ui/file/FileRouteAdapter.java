package com.kami.fileexplorer.ui.file;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;

import com.kami.fileexplorer.R;
import com.kami.fileexplorer.bean.FileRoute;
import com.kami.fileexplorer.ui.BaseAdapter;
import com.kami.fileexplorer.widget.FSImageView;
import com.kami.fileexplorer.widget.FSTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        return new FileRouteViewHolder(getContentView(parent, R.layout.list_route_item));
    }

   final static class FileRouteViewHolder extends BaseAdapter.BaseViewHolder<FileRoute> {
       @BindView(R.id.route_name)
       FSTextView mRouteNameText;
        public FileRouteViewHolder(View itemView) {
            super(itemView);
            FSImageView arrowImage = ButterKnife.findById(itemView, R.id.route_image);
            arrowImage.setColorFilter(ContextCompat.getColor(itemView.getContext(), R.color.file_route_arrow_color));
        }

        @Override
        public void updateViewData(FileRoute item) {
            mRouteNameText.setText(item.getName());
        }
    }
}
