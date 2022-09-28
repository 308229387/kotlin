package com.example.kotlin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kotlin.adapter.MainListAdapter;
import com.example.kotlin.base.BaseActivity;
import com.example.kotlin.data.MainBean;
import com.example.kotlin.databinding.ExpandableListBinding;
import com.example.kotlin.utils.AssetsUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

/**
 * 子条目会有点击无效的情况，需要在子view布局文件中加一行代码      android:descendantFocusability="blocksDescendants"
 */
public class MainListActivity extends BaseActivity<ExpandableListBinding> {
    ArrayList<MainBean> allData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AssetsUtils assetsUtils = new AssetsUtils();
        String name = "all_data.json";

        String tmp = assetsUtils.readAssetsText(this, name);
//        Log.d("song_test", tmp);
        Logger.json(tmp);
        allData = new Gson().fromJson(tmp, new TypeToken<ArrayList<MainBean>>() {
        }.getType());
//        Log.d("song_test", allData.get(0).getName());

        initView();
    }

    private void initView() {
        MainListAdapter adapter = new MainListAdapter(this, allData);
        viewBind.expandListId.setAdapter(adapter);

        //默认展开第一个数组
        viewBind.expandListId.expandGroup(0);
        //关闭数组某个数组，可以通过该属性来实现全部展开和只展开一个列表功能
        //expand_list_id.collapseGroup(0);
        viewBind.expandListId.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                return false;
            }
        });
        //子视图的点击事件
        viewBind.expandListId.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                toDetail(allData.get(groupPosition).getData().get(childPosition).getTitle(), allData.get(groupPosition).getData().get(childPosition).getContent());
                return true;
            }
        });
        //用于当组项折叠时的通知。
        viewBind.expandListId.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
//                ToastUtil.showTextViewPrompt("折叠了数据___" + groups[groupPosition]);
            }
        });
        //
        //用于当组项折叠时的通知。
        viewBind.expandListId.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
//                ToastUtil.showTextViewPrompt("展开了数据___" + groups[groupPosition]);
            }
        });
    }

    private void toDetail(String title, String content) {
        Intent intent = new Intent(MainListActivity.this, QADetailActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("answer", content);
        startActivity(intent);
    }

    @NonNull
    @Override
    public ExpandableListBinding createViewBinding() {
        return ExpandableListBinding.inflate(getLayoutInflater());
    }


}
