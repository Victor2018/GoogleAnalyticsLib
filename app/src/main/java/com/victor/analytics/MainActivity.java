package com.victor.analytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.victor.analytics.library.AnalyticsHelper;
import com.victor.analytics.library.DateUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnSendCustomAction,mBtnSendScreenName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize () {
        mBtnSendCustomAction = findViewById(R.id.btn_send_custom_action);
        mBtnSendScreenName = findViewById(R.id.btn_send_screen_name);

        mBtnSendCustomAction.setOnClickListener(this);
        mBtnSendScreenName.setOnClickListener(this);
        AnalyticsHelper.getInstance().init(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send_custom_action:
                AnalyticsHelper.getInstance().sendCustomAction("PlayCategory","play action","play lable->" + DateUtil.getTodayDate(),System.currentTimeMillis());
                break;
            case R.id.btn_send_screen_name:
                AnalyticsHelper.getInstance().sendScreenName("crash then play video!->" + DateUtil.getTodayDate());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AnalyticsHelper.getInstance().onDestroy();
    }
}
