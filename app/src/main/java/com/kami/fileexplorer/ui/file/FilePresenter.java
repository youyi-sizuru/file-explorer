package com.kami.fileexplorer.ui.file;

import com.kami.fileexplorer.data.FileExplorer;
import com.kami.fileexplorer.util.schedulers.SchedulerProvider;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * author: youyi_sizuru
 * data: 2017/7/16
 */

class FilePresenter implements FileContract.Presenter {
    private CompositeDisposable mDisposable;
    private FileContract.View mView;
    private FileExplorer mFileExplorer;

    FilePresenter(FileContract.View view, FileExplorer fileExplorer) {
        mView = view;
        this.mFileExplorer = fileExplorer;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribe() {
        listFiles();
    }

    private void listFiles() {
       Disposable disposable = Observable.just(mView.getPath())
                .map(mFileExplorer::getFiles)
                .subscribeOn(SchedulerProvider.getInstance().io())
                .observeOn(SchedulerProvider.getInstance().ui())
                .subscribe(mView::listFile, throwable -> mView.notifyError(throwable.getMessage()));
        mDisposable.add(disposable);
    }

    @Override
    public void unSubscribe() {
        mDisposable.clear();
    }
}
