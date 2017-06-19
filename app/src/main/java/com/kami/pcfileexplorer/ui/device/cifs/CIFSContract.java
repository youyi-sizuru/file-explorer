package com.kami.pcfileexplorer.ui.device.cifs;

import android.content.Context;
import android.support.annotation.Nullable;

import com.kami.pcfileexplorer.BasePresenter;
import com.kami.pcfileexplorer.BaseView;

/**
 * Created by youyi on 2017/6/17.
 */

public interface CIFSContract {
    interface View extends BaseView<Presenter> {
        void setLoggerText(@Nullable String text);
        @Nullable
        Context getViewContext();
    }

    interface Presenter extends BasePresenter {

    }
}
