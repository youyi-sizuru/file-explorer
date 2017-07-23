package com.kami.fileexplorer.ui.device.cifs;

import android.content.Context;

import com.kami.fileexplorer.BasePresenter;
import com.kami.fileexplorer.BaseView;
import com.kami.fileexplorer.bean.CIFSDevice;

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
