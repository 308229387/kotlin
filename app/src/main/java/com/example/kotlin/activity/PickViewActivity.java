package com.example.kotlin.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kotlin.R;
import com.example.kotlin.utils.AssetsUtils;
import com.example.kotlin.utils.ToastUtil;
import com.example.kotlin.utils.UriToPath;

public class PickViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_file);

        AssetsUtils assetsUtils = new AssetsUtils();
        String treeData = assetsUtils.readAssetsText(this, "tree.json");
        ((TextView)findViewById(R.id.local_data)).setText(treeData);
    }

    public void pick(View view){
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("*/*");
            this.startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            // 用户未选择任何文件，直接返回
            return;
        }
        Uri uri = data.getData(); // 获取用户选择文件的URI
        ToastUtil.showTextViewPrompt(UriToPath.getFileAbsolutePath(this,uri));
    }
}
