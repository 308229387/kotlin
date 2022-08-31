package com.example.kotlin.activity;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kotlin.adapter.ExpandableListviewAdapter;
import com.example.kotlin.base.BaseActivity;
import com.example.kotlin.databinding.ExpandableListBinding;
import com.example.kotlin.databinding.MainListBinding;
import com.example.kotlin.utils.ToastUtil;

import java.util.List;

/**
 * 子条目会有点击无效的情况，需要在子view布局文件中加一行代码      android:descendantFocusability="blocksDescendants"
 * */
public class ExpandableListActivity extends BaseActivity<MainListBinding> {

    //Model：定义的数据
    private String[] groups = {"开发部", "人力资源部", "销售部"};

    //注意，字符数组不要写成{{"A1,A2,A3,A4"}, {"B1,B2,B3,B4，B5"}, {"C1,C2,C3,C4"}}
    private String[][] childs = {{"赵珊珊", "钱丹丹", "孙可可", "李冬冬"}, {"周大福", "吴端口", "郑非", "王疯狂"}, {}};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("song_test", "+++");
        List<ApplicationInfo> allApps = getPackageManager().getInstalledApplications(0);
        for(ApplicationInfo ai : allApps) {
            Log.d("song_test", ai.packageName);
        }
        initView();
    }

    private void initView() {
        ExpandableListviewAdapter adapter = new ExpandableListviewAdapter(this, groups, childs);
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
    public MainListBinding createViewBinding() {
        return MainListBinding.inflate(getLayoutInflater());
    }
}
