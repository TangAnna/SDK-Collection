package com.tang.hmspush;

import static com.tang.hmspush.MyHmsMessageService.TAG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.huawei.secure.android.common.util.LogsUtil;

public class HmsGetTokenActivity extends Activity implements View.OnClickListener {

    private TextView mtokenInforView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_get_token);
        mtokenInforView = findViewById(R.id.tokeninfo);
        findViewById(R.id.btn_get_token).setOnClickListener(this);
        findViewById(R.id.btn_delete_token).setOnClickListener(this);
//        getIntentData(getIntent());
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.btn_get_token:
                getToken();
                break;
            case R.id.btn_delete_token:
                deleteToken();
                break;
            default:
                break;
        }
    }

    private void getToken() {
        new Thread() {
            @Override
            public void run() {
                try {
                    // read from agconnect-services.json
                    String appId = AGConnectServicesConfig.fromContext(getApplicationContext()).getString("client/app_id");
                    String token = HmsInstanceId.getInstance(getApplicationContext()).getToken(appId, "HCM");
                    LogUtils.i(TAG, "get token:" + token);
                    // 1. After a token is obtained by using the getToken method, null judgment must be performed.
                    // 2. In the outer code segment of the getToken method, you need to add exception capture processing.
                    if (!TextUtils.isEmpty(token)) {
                        sendRegTokenToServer(token);
                    }

                    mtokenInforView.append("\n" + "get token:" + token);
                } catch (ApiException e) {
                    LogUtils.e(TAG, "get token failed, " + e);
                    mtokenInforView.append("\n" + "get token failed, " + e);
                }
            }
        }.start();
    }

    private void sendRegTokenToServer(String token) {
        mtokenInforView.post(new Runnable() {
            @Override
            public void run() {
                LogsUtil.e(TAG, "sending token to server. token:" + token);
            }
        });


    }

    private void deleteToken() {
        new Thread() {
            @Override
            public void run() {
                try {
                    // read from agconnect-services.json
                    String appId = AGConnectServicesConfig.fromContext(HmsGetTokenActivity.this).getString("client/app_id");
                    HmsInstanceId.getInstance(HmsGetTokenActivity.this).deleteToken(appId, "HCM");
                    LogUtils.i(TAG, "deleteToken success.");
                    mtokenInforView.append("\n" + "deleteToken success");
                } catch (ApiException e) {
                    LogUtils.e(TAG, "deleteToken failed." + e);
                    mtokenInforView.append("\n" + "deleteToken failed." + e);
                }
            }
        }.start();
    }

    private void getIntentData(Intent intent) {
        if (intent != null) {
            String msgid = intent.getStringExtra("_push_msgid");
            String cmdType = intent.getStringExtra("_push_cmd_type");
            int notifyId = intent.getIntExtra("_push_notifyid", -1);
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                for (String key : bundle.keySet()) {
                    String content = bundle.getString(key);
                    LogUtils.e(TAG, "receive data from push, key = " + key + ", content = " + content);
                }
            }
            LogUtils.e(TAG, "receive data from push, msgId = " + msgid + ", cmd = " + cmdType + ", notifyId = " + notifyId);
        } else {
            LogUtils.e(TAG, "intent is null");
        }
    }
}
