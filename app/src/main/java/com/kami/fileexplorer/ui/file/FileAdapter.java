package com.kami.fileexplorer.ui.file;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.kami.fileexplorer.R;
import com.kami.fileexplorer.data.FileExplorer;
import com.kami.fileexplorer.ui.BaseAdapter;
import com.kami.fileexplorer.util.CommonUtils;
import com.kami.fileexplorer.widget.FSImageView;
import com.kami.fileexplorer.widget.FSTextView;


import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

/**
 * author: youyi_sizuru
 * data: 2017/8/6
 */
class FileAdapter extends BaseAdapter<FileExplorer.File, FileAdapter.FileViewHolder> {

    FileAdapter(@NonNull Context context) {
        super(context);
    }

    @Override
    public FileViewHolder onCreateBaseViewHolder(ViewGroup parent, int viewType) {
        return new FileViewHolder(getContentView(parent, R.layout.list_file_item));
    }

    static class FileViewHolder extends BaseAdapter.BaseViewHolder<FileExplorer.File> {
        @BindView(R.id.file_icon)
        FSImageView mIcon;
        @BindView(R.id.file_name)
        FSTextView mName;
        @BindView(R.id.simple_data_text)
        FSTextView mDataText;

        FileViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void updateViewData(FileExplorer.File item) {
            mName.setText(item.getName());
            if (item.isDirectory()) {
                mDataText.setVisibility(View.GONE);
                mIcon.setImageResource(R.drawable.folder_icon);
            } else {
                mDataText.setVisibility(View.VISIBLE);
                mDataText.setText(String.format("%s %s", CommonUtils.formatFileSize(item.length()), CommonUtils
                        .formatFileModifiedTime(item.lastModified())));
                mIcon.setImageResource(R.drawable.file_icon);
            }
        }
    }
}
