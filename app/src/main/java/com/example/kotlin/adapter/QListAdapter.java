package com.example.kotlin.adapter;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.kotlin.R;
import com.example.kotlin.data.NormalBean;
import com.example.kotlin.data.QABean;
import com.example.kotlin.utils.ToolsUtil;
import com.example.kotlin.views.dialog.RememberDialog;
import com.orhanobut.hawk.Hawk;

import org.jetbrains.annotations.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

import kotlin.jvm.internal.Intrinsics;

/**
 * 防list错位有两部，1是在setAdapter前调用adapter.setHasStableIds(true);2是要在Adapter中写加上下面的代码
 *
 * @Override public long getItemId(int position) {
 * return position;
 * }
 */
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
        recordText = holder.findView(R.id.tv_record);
        recordText.setOnClickListener(v -> {


            RememberDialog dialog = new RememberDialog(getContext());
            dialog.setListener(new RememberDialog.RememberDialogCallBack() {
                @Override
                public void result() {
                    QABean tmp = Hawk.get(bean.getTitle(), new QABean());

                    tmp.setLast(new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
                    int tag = 0;
                    Log.d("song_test", tmp.getCount() + "");
                    if (tmp.getCount() == 0) {
                        tag = 1;
                    } else if (tmp.getCount() == 1) {
                        tag = 2;
                    } else if (tmp.getCount() == 2) {
                        tag = 3;
                    } else if (tmp.getCount() > 2) {
                        tag = 4;
                    }
                    tmp.setNext(beforeAfterDate(tag));
                    tmp.setCount(tmp.getCount() + 1);
                    Hawk.put(bean.getTitle(), tmp);
                    notifyDataSetChanged();
                    dialog.dismiss();
                }

                @Override
                public void cancel() {
                    dialog.dismiss();
                }
            }).show();
        });

        if (Hawk.contains(bean.getTitle())) {
            QABean tmp = Hawk.get(bean.getTitle());
            switch (tmp.getCount()) {
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
            if (tmp.getCount() != 0) {
                holder.setText(R.id.tv_record, "已学习" + tmp.getCount() + "次");
            }

            holder.setText(R.id.tv_last_time, tmp.getLast());
            holder.setText(R.id.tv_next_time, tmp.getNext());
        }
//        holder.setText(R.id.tv_time_content, bean.getShotTime());
//        holder.setText(R.id.tv_task_content, bean.getTaskName());
//        holder.setText(R.id.tv_source, bean.getDataTypeDesc());
    }

    //必不可少，防止错位混乱
    @Override
    public long getItemId(int position) {
        return position;
    }

    public static String beforeAfterDate(int days) {
        long nowTime = System.currentTimeMillis();
        long changeTimes = days * 24L * 60 * 60 * 1000;
        return getStrTime(String.valueOf(nowTime + changeTimes), "yyyy年MM月dd日");
    }

    public static String getStrTime(String timeStamp, String format) {
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }

}
