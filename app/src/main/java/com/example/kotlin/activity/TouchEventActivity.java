package com.example.kotlin.activity;

import android.Manifest;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kotlin.R;
import com.example.kotlin.utils.permissionutil.PermissionListener;
import com.example.kotlin.utils.permissionutil.PermissionUtil;
import com.example.kotlin.views.dialog.RecordSettingDialog;

import java.util.List;


/**
 * Author: sym
 * Date: 2021/9/28 10:44 AM
 * Describe:
 */
public class TouchEventActivity extends AppCompatActivity {
    private TextView touchLayout;
    private float mLastTouchY;
    private boolean mUpDirection;
    private RecordSettingDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_event_activity);
        touchLayout = (TextView) findViewById(R.id.touch_layout);
        dialog = new RecordSettingDialog(this);
        touchLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String[] permissions = {Manifest.permission.RECORD_AUDIO};
                PermissionUtil permissionUtil = new PermissionUtil(TouchEventActivity.this);

                permissionUtil.requestPermissions(permissions, new PermissionListener() {
                    @Override
                    public void onGranted() {
                        moveAction(v, event);
                    }

                    @Override
                    public void onDenied(List<String> deniedPermission) {

                    }

                    @Override
                    public void onShouldShowRationale(List<String> deniedPermission) {
                        if (!dialog.isShowing()) {
                            showRecordDialog();
                        }
                    }
                });

                return true;
            }
        });
    }

    private void showRecordDialog() {
        dialog.setLeftAndRightText("不允许", "设置");
        dialog.setAttributes(this);
        dialog.setListener(new RecordSettingDialog.RecordDialogCallBack() {
            @Override
            public void result() {
                PermissionUtil.gotoPermission(TouchEventActivity.this);
                dialog.dismiss();
            }

            @Override
            public void cancel() {
                dialog.dismiss();
            }
        }).show();
    }


    private void moveAction(View v, MotionEvent event) {
        float mOffsetLimit = 70 * v.getContext().getResources().getDisplayMetrics().density;
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mLastTouchY = event.getY();
            mUpDirection = false;
            ((TextView) v).setText("松开 结束");
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            if (mLastTouchY - event.getY() > mOffsetLimit && !mUpDirection) {
                mUpDirection = true;
                ((TextView) v).setText("按住 说话");
            } else if (event.getY() - mLastTouchY > -mOffsetLimit && mUpDirection) {
                mUpDirection = false;
                ((TextView) v).setText("松开 结束");
            }


        } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
            ((TextView) v).setText("按住 说话");
        }

    }
}
