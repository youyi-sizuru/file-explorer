package com.kami.pcfileexplorer.ui.device.cifs;

import android.content.Context;

import com.kami.pcfileexplorer.BasePresenter;
import com.kami.pcfileexplorer.BaseView;
import com.kami.pcfileexplorer.bean.CIFSDevice;

import java.util.List;

/**
 * author: youyi_sizuru
 * data: 2017/6/17
 */

interface CIFSContract {
    interface View extends BaseView<Presenter> {
        Context getViewContext();
        void setCifsList(List<CIFSDevice> deviceList);
        void notifyError(String errorMessage);
    }

    interface Presenter extends BasePresenter {

    }
}
