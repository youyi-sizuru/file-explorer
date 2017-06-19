package com.kami.pcfileexplorer.ui.device.cifs;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import com.kami.pcfileexplorer.data.cifs.CIFSSearcher;
import com.kami.pcfileexplorer.util.NetUtils;
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

    public CIFSPresenter(@NonNull CIFSContract.View view) {
        mDisposable = new CompositeDisposable();
        this.mView = view;
    }

    @Override
    public void subscribe() {
        Context context = mView.getViewContext();
        if (context == null) {
            mView.setLoggerText("context is null");
            return;
        }
        if (!NetUtils.isWifiConnected(context)) {
            mView.setLoggerText("wifi is not connected");
            return;
        }
        final StringBuilder logBuilder = new StringBuilder();
        Disposable disposable = CIFSSearcher.getInstance()
                .searchDevices()
                .subscribeOn(SchedulerProvider.getInstance().io())
                .observeOn(SchedulerProvider.getInstance().ui())
                .subscribe(text -> logBuilder.append(text + "\n"),
                        throwable -> {
                            mView.setLoggerText(throwable.getMessage());
                        },
                        () -> {
                            mView.setLoggerText(logBuilder.toString());
                        });
        mDisposable.add(disposable);
    }



    @Override
    public void unSubscribe() {
        mDisposable.clear();
    }
}
