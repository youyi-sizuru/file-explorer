package com.kami.pcfileexplorer.ui.device.cifs;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;

import com.kami.pcfileexplorer.data.cifs.CIFSSearcher;
import com.kami.pcfileexplorer.util.NetUtils;
import com.kami.pcfileexplorer.util.schedulers.SchedulerProvider;

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
        if (!NetUtils.isWifiConnected(context)) {
            mView.setLoggerText("wifi is not connected");
            return;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
        final StringBuilder logBuilder = new StringBuilder();
        Disposable disposable = CIFSSearcher.getInstance()
                .searchDevices(dhcpInfo.ipAddress)
                .subscribeOn(SchedulerProvider.getInstance().computation())
                .observeOn(SchedulerProvider.getInstance().ui())
                .subscribe(text -> logBuilder.append(text),
                        throwable -> mView.setLoggerText(throwable.getMessage()),
                        () ->  mView.setLoggerText(logBuilder.toString()));
        mDisposable.add(disposable);
    }


    @Override
    public void unSubscribe() {
        mDisposable.clear();
    }
}
