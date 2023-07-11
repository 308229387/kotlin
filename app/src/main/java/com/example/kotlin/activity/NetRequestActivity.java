package com.example.kotlin.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kotlin.R;
import com.example.kotlin.net.GetResultBean;
import com.example.kotlin.net.JsonParamsBean;
import com.example.kotlin.net.NetRequestContract;
import com.example.kotlin.net.NetRequestPresenter;
import com.example.kotlin.net.PostResultBean;
import com.google.gson.Gson;


/**
 * Author: sym
 * Date: 2021/9/28 10:44 AM
 * Describe:
 */
public class NetRequestActivity extends AppCompatActivity implements NetRequestContract.View {
   public String params11 = "{\"data\":{\"jh\":\"110105197912260011\",\"orgId\":\"010000000000\",\"sfzh\":\"110105197912260011\",\"userId\":\"1b02931a-4c7f-4aad-9336-b4a7be269bbf\",\"xm\":\"毛崟\"},\"method\":\"post\",\"type\":\"json\",\"url\":\"user\\/app\\/login\"}";
    private TextView resultLayout;
    private TextView getButton;
    private TextView postButton;

    private NetRequestContract.Presenter mPresenter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net_requst_layout);
        resultLayout = (TextView) findViewById(R.id.result_layout);
        getButton = (TextView) findViewById(R.id.get_layout);
        postButton = (TextView) findViewById(R.id.post_layout);
        mPresenter = new NetRequestPresenter(this);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getRequest("params");
            }
        });

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonParamsBean<Data> params = new JsonParamsBean<>("user/app/login","json","post",new Data());


                mPresenter.postRequest(params);
            }
        });

    }


    @Override
    public void onError(String msg) {
        resultLayout.setText(msg);
    }

    @Override
    public void updateGetUI(GetResultBean bean) {
        resultLayout.setText(bean.getToken());
    }

    @Override
    public void updatePostUI(PostResultBean bean) {
        resultLayout.setText(bean.getJyaq());
    }


    public class Data{
        public String jh = "110105197912260011";
        public String orgId = "010000000000";
        public String sfzh = "130402196810231590";
        public String userId = "1b02931a-4c7f-4aad-9336-b4a7be269bbf";
        public String xm = "毛崟";
    }
}
