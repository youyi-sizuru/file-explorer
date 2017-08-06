package com.kami.fileexplorer.ui;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * author: youyi_sizuru
 * data: 2017/7/7
 */

public abstract class BaseAdapter<T, VH extends BaseAdapter.BaseViewHolder<T>> extends RecyclerView.Adapter<VH> {
    private List<T> mList;
    private Context mContext;
    private OnItemClickListener mItemClickListener;

    public BaseAdapter(@NonNull Context context) {
        this(context, null);
    }

    public BaseAdapter(@NonNull Context context, @Nullable List<T> list) {
        this.mContext = context;
        this.mList = list;
    }

    public void setItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        VH viewHolder = onCreateBaseViewHolder(parent, viewType);
        viewHolder.setAdapter(this);
        return viewHolder;
    }

    public abstract VH onCreateBaseViewHolder(ViewGroup parent, int viewType);

    public void add(T item) {
        if (mList == null) {
            mList = new ArrayList<>();
        }
        mList.add(item);
        notifyItemInserted(mList.size() - 1);
    }

    public void remove() {
        if (getItemCount() == 0) {
            return;
        }
        int position = getItemCount() - 1;
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public void removeTo(int position) {
        int count = getItemCount();
        if (count <= position + 1) {
            return;
        }
        for (int i = count - 1; i > position; i--) {
            mList.remove(i);
        }
        notifyItemRangeRemoved(position + 1, count - position - 1);
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

    public static abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {
        private BaseAdapter mAdapter;

        public BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            OnItemClickListener listener = mAdapter.mItemClickListener;
            if (listener != null) {
                listener.onItemClick(mAdapter, this.getAdapterPosition(), this.itemView);
            }
        }

        void setAdapter(BaseAdapter adapter) {
            this.mAdapter = adapter;
        }

        public abstract void updateViewData(T item);
    }

    public interface OnItemClickListener {
        void onItemClick(BaseAdapter adapter, int position, View view);
    }
}
