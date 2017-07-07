package com.kami.pcfileexplorer.ui;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * author: youyi_sizuru
 * data: 2017/7/7
 */

public abstract class BaseAdapter<T, VH extends BaseViewHolder<T>> extends RecyclerView.Adapter<VH> {
    private List<T> mList;
    private Context mContext;

    public BaseAdapter(@NonNull Context context) {
        this(context, null);
    }

    public BaseAdapter(@NonNull Context context, @Nullable List<T> list) {
        this.mContext = context;
        this.mList = list;
    }

    protected View getContentView(ViewGroup parent, @LayoutRes int layout) {
        return LayoutInflater.from(mContext).inflate(layout, parent, false);
    }

    public void setList(List<T> list) {
        this.mList = list;
        this.notifyDataSetChanged();
    }

    public List<T> getList() {
        return mList;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.updateViewData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }
}
