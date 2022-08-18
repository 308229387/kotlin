package com.example.kotlin.adapter;

import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.kotlin.R;
import com.example.kotlin.data.ControlItemBean;


public class PersonWarningAdapter extends BaseQuickAdapter<ControlItemBean, BaseViewHolder> implements LoadMoreModule {
    public PersonWarningAdapter() {
        super(R.layout.item_control_warning);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, ControlItemBean bean) {
        /**
         * 如果里面想放listener，然后对数据有操作，一定是在listener里直接new，不能放一个公共的，会有混乱使用的问题
         * */
        if (getItemPosition(bean) == 0) {
            holder.getView(R.id.view_top).setVisibility(View.VISIBLE);
        } else {
            holder.getView(R.id.view_top).setVisibility(View.GONE);
        }
        holder.setText(R.id.tv_name, bean.getName());
        holder.setText(R.id.tv_location_content, bean.getAddress());
        holder.setText(R.id.tv_time_content, bean.getShotTime());
        holder.setText(R.id.tv_task_content, bean.getTaskName());
        holder.setText(R.id.tv_source, bean.getDataTypeDesc());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
