package com.kami.fileexplorer.ui.file;

/**
 * author: youyi_sizuru
 * data: 2017/7/16
 */

class FilePresenter implements FileContract.Presenter {
    private FileContract.View mView;
    FilePresenter(FileContract.View view) {
        mView = view;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }
}
