package com.kami.fileexplorer.util.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: youyi_sizuru
 * data: 2017/4/16
 */

public class SchedulerProvider implements BaseSchedulerProvider {
    private static SchedulerProvider instance = new SchedulerProvider();

    public static SchedulerProvider getInstance() {
        return instance;
    }

    private SchedulerProvider() {
    }

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
