package com.example.kotlin.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.example.kotlin.R;
import com.example.kotlin.adapter.PersonWarningAdapter;
import com.example.kotlin.base.BaseActivity;
import com.example.kotlin.data.ControlItemBean;
import com.example.kotlin.databinding.LoadMoreLayoutBinding;
import com.example.kotlin.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 防list错位有两部，1是在setAdapter前调用adapter.setHasStableIds(true);2是要在Adapter中写加上下面的代码
 * @Override
 * public long getItemId(int position) {
 *     return position;
 * }
 * */
public class LoadMoreActivity extends BaseActivity<LoadMoreLayoutBinding> implements OnItemClickListener,
        OnLoadMoreListener {
    private PersonWarningAdapter adapter;
    private boolean isRefresh = true;
    private int pageIndex = 1;
    private int total = 50;//总数据条数

    private int dataCount = 0;//辅助理解计数，实际开发中没用

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //上拉刷新 配置
        viewBind.srlLayout.setColorSchemeColors(Color.rgb(47, 137, 250));
        viewBind.srlLayout.setOnRefreshListener(this::refresh);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new PersonWarningAdapter();
        adapter.setHasStableIds(true);
        viewBind.rvList.setLayoutManager(layoutManager);
        viewBind.rvList.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.getLoadMoreModule().setOnLoadMoreListener(this);
        adapter.getLoadMoreModule().setAutoLoadMore(true);

        //当自动加载开启，同时数据不满一屏时，是否继续执行自动加载更多(默认为true)
        adapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);

        List<ControlItemBean> list = new ArrayList();
        adapter.setList(list);
        adapter.notifyDataSetChanged();

        updateUI(getTempList());
    }


    private void refresh() {
        ToastUtil.showTextViewPrompt("刷新");
        dataCount = 0;
        isRefresh = true;
        pageIndex = 1;
        viewBind.getRoot().postDelayed(() -> {
            updateUI(getTempList());
        }, 1000);

    }


    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        ToastUtil.showTextViewPrompt("点击了第" + position + "个条目");
    }

    @Override
    public void onLoadMore() {
        ToastUtil.showTextViewPrompt("加载更多");
        viewBind.getRoot().postDelayed(() -> {
            updateUI(getTempList());
        }, 1000);
    }

    public void updateUI(List<ControlItemBean> dataList) {
        viewBind.srlLayout.setRefreshing(false);
        adapter.getLoadMoreModule().setEnableLoadMore(true);
        if (dataList.size() > 0) {
            boolean isHasData = dataList != null && !dataList.isEmpty();
            if (isRefresh) {
                isRefresh = false;
                adapter.setList(dataList);
                if (!isHasData) {
                    adapter.setEmptyView(getEmptyDataView());
                }
            } else {
                if (isHasData) {
                    adapter.addData(dataList);
                }
            }
            if (pageIndex * 10 < total) {
                pageIndex++;
                adapter.getLoadMoreModule().loadMoreComplete();
            } else {
                adapter.getLoadMoreModule().loadMoreEnd(true);
            }
        }
    }

    private View getEmptyDataView() {
        View notDataView = getLayoutInflater().inflate(R.layout.recycler_empty_view, viewBind.rvList, false);
        notDataView.setOnClickListener(v -> refresh());
        return notDataView;
    }

    //模拟请求获取的数据
    private List<ControlItemBean> getTempList() {
        List<ControlItemBean> tmpList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ControlItemBean tmp = new ControlItemBean();
            tmp.setName("我是第" + ++dataCount + "条数据");
            tmp.setAddress("中国河北省石家庄市");
            tmp.setShotTime("2022-07-20");
            tmp.setTaskName("上拉加载、下拉刷新");
            tmpList.add(tmp);
        }
        return tmpList;
    }

    @Override
    public LoadMoreLayoutBinding createViewBinding() {
        return LoadMoreLayoutBinding.inflate(getLayoutInflater());
    }
}
