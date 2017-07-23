package com.kami.fileexplorer.util.schedulers;

import io.reactivex.Scheduler;

/**
 * Created by youyi on 2017/4/16.
 */

public interface BaseSchedulerProvider {
    /**
     * @return 计算线程调度
     */
    Scheduler computation();

    /**
     * @return I/O 线程调度
     */
    Scheduler io();

    /**
     * @return ui线程调度
     */
    Scheduler ui();
}
