package com.kami.pcfileexplorer.ui.device.cifs;

import com.kami.pcfileexplorer.data.cifs.CIFSSearcher;
import com.kami.pcfileexplorer.util.schedulers.SchedulerProvider;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by youyi on 2017/6/17.
 */

public class CIFSPresenter implements CIFSContract.Presenter {
    private CompositeDisposable mDisposable;
    private CIFSContract.View mView;

    public CIFSPresenter(CIFSContract.View view) {
        mDisposable = new CompositeDisposable();
        this.mView = view;
    }

    @Override
    public void subscribe() {
        Disposable disposable = CIFSSearcher.getInstance()
                .searchDevices()
                .subscribeOn(SchedulerProvider.getInstance().io())
                .observeOn(SchedulerProvider.getInstance().ui())
                .subscribe(text -> mView.setLoggerText(text));
        mDisposable.add(disposable);
    }

    @Override
    public void unSubscribe() {
        mDisposable.clear();
    }
}
