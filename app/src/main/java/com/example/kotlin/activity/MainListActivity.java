package com.example.kotlin.activity;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kotlin.adapter.ExpandableListviewAdapter;
import com.example.kotlin.adapter.MainListAdapter;
import com.example.kotlin.base.BaseActivity;
import com.example.kotlin.data.MainBean;
import com.example.kotlin.data.NormalBean;
import com.example.kotlin.databinding.ExpandableListBinding;
import com.example.kotlin.utils.AssetsUtils;
import com.example.kotlin.utils.ToastUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * 子条目会有点击无效的情况，需要在子view布局文件中加一行代码      android:descendantFocusability="blocksDescendants"
 * */
public class MainListActivity extends BaseActivity<ExpandableListBinding> {
    ArrayList<MainBean> allData;
    //Model：定义的数据
    private String[] groups = {"开发部", "人力资源部", "销售部"};

    //注意，字符数组不要写成{{"A1,A2,A3,A4"}, {"B1,B2,B3,B4，B5"}, {"C1,C2,C3,C4"}}
    private String[][] childs = {{"赵珊珊", "钱丹丹", "孙可可", "李冬冬"}, {"周大福", "吴端口", "郑非", "王疯狂"}, {}};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AssetsUtils assetsUtils = new AssetsUtils();
        String name = "all_data.json";

        String tmp = assetsUtils.readAssetsText(this, name);
        Log.d("song_test",tmp);
        allData = new Gson().fromJson(tmp, new TypeToken<ArrayList<MainBean>>() {}.getType());
        Log.d("song_test",allData.get(0).getName());

        initView();
    }

    private void initView() {
        MainListAdapter adapter = new MainListAdapter(this,allData);
        viewBind.expandListId.setAdapter(adapter);

        //默认展开第一个数组
        viewBind.expandListId.expandGroup(0);
        //关闭数组某个数组，可以通过该属性来实现全部展开和只展开一个列表功能
        //expand_list_id.collapseGroup(0);
        viewBind.expandListId.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                ToastUtil.showTextViewPrompt(groups[groupPosition]);
                return false;
            }
        });
        //子视图的点击事件
        viewBind.expandListId.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                ToastUtil.showTextViewPrompt(childs[groupPosition][childPosition]);
                return true;
            }
        });
        //用于当组项折叠时的通知。
        viewBind.expandListId.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                ToastUtil.showTextViewPrompt("折叠了数据___" + groups[groupPosition]);
            }
        });
        //
        //用于当组项折叠时的通知。
        viewBind.expandListId.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                ToastUtil.showTextViewPrompt("展开了数据___" + groups[groupPosition]);
            }
        });
    }

    @NonNull
    @Override
    public ExpandableListBinding createViewBinding() {
        return ExpandableListBinding.inflate(getLayoutInflater());
    }
}
