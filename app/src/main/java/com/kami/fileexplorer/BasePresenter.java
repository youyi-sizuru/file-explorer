package com.kami.fileexplorer;

/**
 * MVP-rxjava架构中P模块的接口类
 * Created by youyi on 2017/4/16.
 */
public interface BasePresenter {
    /**
     * 订阅
     */
    void subscribe();

    /**
     * 取消订阅
     */
    void unSubscribe();
}
