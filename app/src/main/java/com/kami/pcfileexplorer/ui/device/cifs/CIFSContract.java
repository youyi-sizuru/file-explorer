package com.kami.pcfileexplorer.ui.device.cifs;

import com.kami.pcfileexplorer.BasePresenter;
import com.kami.pcfileexplorer.BaseView;

/**
 * Created by youyi on 2017/6/17.
 */

public interface CIFSContract {
    interface View extends BaseView<Presenter> {
        void setLoggerText(String text);
    }

    interface Presenter extends BasePresenter {

    }
}
