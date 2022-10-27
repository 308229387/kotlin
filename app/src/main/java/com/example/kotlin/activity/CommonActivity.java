package com.example.kotlin.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kotlin.R;
import com.example.kotlin.base.BaseActivity;
import com.example.kotlin.databinding.ActivityCommonBinding;
import com.example.kotlin.utils.ToastUtil;

public class CommonActivity extends BaseActivity<ActivityCommonBinding> {
    Switch aSwitch;

    @NonNull
    @Override
    public ActivityCommonBinding createViewBinding() {
        return ActivityCommonBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aSwitch = findViewById(R.id.switchBtn);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ToastUtil.showTextViewPrompt("true");
                } else {
                    ToastUtil.showTextViewPrompt("false");
                }
            }
        });
    }
}
