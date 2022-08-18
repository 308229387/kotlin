package com.example.kotlin.activity;

import android.content.Intent;
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
import com.example.kotlin.adapter.QListAdapter;
import com.example.kotlin.base.BaseActivity;
import com.example.kotlin.data.NormalBean;
import com.example.kotlin.databinding.QListLayoutBinding;
import com.example.kotlin.utils.AssetsUtils;
import com.example.kotlin.utils.ToastUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class QListActivity extends BaseActivity<QListLayoutBinding> implements OnItemClickListener,
        OnLoadMoreListener {
    private List<NormalBean.DataInFo> data;
    private QListAdapter adapter;
    private boolean isRefresh = true;
    private int pageIndex = 1;
    private int total = 0;//总数据条数

    private int dataCount = 0;//辅助理解计数，实际开发中没用

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBind.navigationBack.setOnClickListener(v -> {
            finish();
        });

        AssetsUtils assetsUtils = new AssetsUtils();
        String name = "component.json";
        if(getIntent().getStringExtra("intent") != null){
            name = getIntent().getStringExtra("intent");
        }
        String tmp = assetsUtils.readAssetsText(this, name);
        NormalBean tmpData = new Gson().fromJson(tmp, NormalBean.class);
        data = tmpData.getData();
        total = data.size();

        //上拉刷新 配置
        viewBind.srlLayout.setColorSchemeColors(Color.rgb(47, 137, 250));
        viewBind.srlLayout.setOnRefreshListener(this::refresh);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new QListAdapter();
        adapter.setHasStableIds(true);
        viewBind.rvList.setLayoutManager(layoutManager);
        viewBind.rvList.setAdapter(adapter);
        viewBind.rvList.setItemViewCacheSize(500);
        adapter.setOnItemClickListener(this);
        adapter.getLoadMoreModule().setOnLoadMoreListener(this);
        adapter.getLoadMoreModule().setAutoLoadMore(true);

        //当自动加载开启，同时数据不满一屏时，是否继续执行自动加载更多(默认为true)
        adapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);

        List<NormalBean.DataInFo> list = new ArrayList();
        adapter.setList(list);
        adapter.notifyDataSetChanged();

        updateUI(data);
    }


    private void refresh() {
        ToastUtil.showTextViewPrompt("刷新");
        dataCount = 0;
        isRefresh = true;
        pageIndex = 1;
        viewBind.getRoot().postDelayed(() -> {
            updateUI(data);
        }, 1000);

    }


    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        Intent intent = new Intent(QListActivity.this, QADetailActivity.class);
        intent.putExtra("title", data.get(position).getTitle());
        intent.putExtra("answer", data.get(position).getContent());
        startActivity(intent);
    }

    @Override
    public void onLoadMore() {
        ToastUtil.showTextViewPrompt("加载更多");
        viewBind.getRoot().postDelayed(() -> {
            updateUI(data);
        }, 1000);
    }

    public void updateUI(List<NormalBean.DataInFo> dataList) {
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

    @Override
    public QListLayoutBinding createViewBinding() {
        return QListLayoutBinding.inflate(getLayoutInflater());
    }
}
