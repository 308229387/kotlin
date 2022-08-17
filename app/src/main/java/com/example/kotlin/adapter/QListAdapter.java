package com.example.kotlin.adapter;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.kotlin.R;
import com.example.kotlin.data.NormalBean;
import com.example.kotlin.utils.ToastUtil;
import com.orhanobut.hawk.Hawk;

/**
 * 防list错位有两部，1是在setAdapter前调用adapter.setHasStableIds(true);2是要在Adapter中写加上下面的代码
 * @Override
 * public long getItemId(int position) {
 *     return position;
 * }
 * */
public class QListAdapter extends BaseQuickAdapter<NormalBean.DataInFo, BaseViewHolder> implements LoadMoreModule {
    TextView recordText;

    public QListAdapter() {
        super(R.layout.q_list_item);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, NormalBean.DataInFo bean) {
        if (getItemPosition(bean) == 0) {
            holder.getView(R.id.view_top).setVisibility(View.VISIBLE);
        } else {
            holder.getView(R.id.view_top).setVisibility(View.GONE);
        }
        holder.setText(R.id.tv_name, bean.getTitle());
        recordText = holder.findView(R.id.tv_record);
        recordText.setOnClickListener(v -> {
            ToastUtil.showTextViewPrompt("记录");
            int t = Hawk.get(bean.getTitle(), 0);
            Hawk.put(bean.getTitle(), t + 1);
            notifyDataSetChanged();
        });

        if (Hawk.contains(bean.getTitle())) {
            int tag = Hawk.get(bean.getTitle());
            switch (tag) {
                case 0:
                    recordText.setBackgroundColor(Color.parseColor("#63A1E6"));
                    break;
                case 1:
                    recordText.setBackgroundColor(Color.parseColor("#FF0000"));
                    break;
                case 2:
                    recordText.setBackgroundColor(Color.parseColor("#FFD700"));

                    break;
                case 3:
                    recordText.setBackgroundColor(Color.parseColor("#006400"));

                    break;
                default:
                    recordText.setBackgroundColor(Color.parseColor("#00FF00"));
                    break;
            }
        }
//        holder.setText(R.id.tv_location_content, bean.getAddress());
//        holder.setText(R.id.tv_time_content, bean.getShotTime());
//        holder.setText(R.id.tv_task_content, bean.getTaskName());
//        holder.setText(R.id.tv_source, bean.getDataTypeDesc());
    }

    //必不可少，防止错位混乱
    @Override
    public long getItemId(int position) {
        return position;
    }

}
