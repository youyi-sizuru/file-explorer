package com.kami.pcfileexplorer.ui;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * author: youyi_sizuru
 * data: 2017/4/9
 */

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }
}
