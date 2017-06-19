package com.kami.pcfileexplorer;

/**
 * MVP-rxjava中的V层接口类
 * Created by youyi on 2017/4/16.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
