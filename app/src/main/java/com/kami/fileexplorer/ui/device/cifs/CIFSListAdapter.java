package com.kami.fileexplorer.ui.device.cifs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.kami.fileexplorer.R;
import com.kami.fileexplorer.bean.CIFSDevice;
import com.kami.fileexplorer.ui.BaseAdapter;
import com.kami.fileexplorer.widget.FSImageView;
import com.kami.fileexplorer.widget.FSTextView;

import java.util.List;

import butterknife.BindView;

/**
 * author: youyi_sizuru
 * data: 2017/7/7
 */

class CIFSListAdapter extends BaseAdapter<CIFSDevice, CIFSListAdapter.DeviceViewHolder> {
    CIFSListAdapter(@NonNull Context context) {
        super(context);
    }

    CIFSListAdapter(@NonNull Context context, @Nullable List<CIFSDevice> list) {
        super(context, list);
    }

    @Override
    public CIFSListAdapter.DeviceViewHolder onCreateBaseViewHolder(ViewGroup parent, int viewType) {
        return new DeviceViewHolder(getContentView(parent, R.layout.list_device_item));
    }

    final static class DeviceViewHolder extends BaseAdapter.BaseViewHolder<CIFSDevice> {
        @BindView(R.id.device_icon)
        FSImageView mDeviceIcon;
        @BindView(R.id.device_name)
        FSTextView mDeviceName;
        DeviceViewHolder(View itemView) {
            super(itemView);
            mDeviceIcon.setImageResource(R.drawable.folder_icon);
        }

        @Override
        public void updateViewData(CIFSDevice item) {
            mDeviceName.setText(item.getHostName());
        }
    }
}
