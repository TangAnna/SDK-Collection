package com.tang.hmspushdemo;

import android.app.Application;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.LogUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * description:
 * time: 2022/6/22 11:50 AM.
 *
 * @author TangAnna
 * email: tang_an@murongtech.com
 * copyright: 北京沐融信息科技股份有限公司
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initFirebase();
    }

    private void initFirebase() {
        //如果使用library的方式集成需要手动初始化
//        //删除已经初始化的配置，确保自己的配置是default
//        FirebaseApp.getInstance().delete();
//        //配置参数从google-service.json文件中查找
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setProjectId("demoapplication-anna")
//                .setApplicationId("1:69567268823:android:23c99fda5ad6637ea42d92")
//                .setApiKey("AIzaSyBNsslLu0Dh2sh-DbX2QMch-0GOOp1aAJE")
//                .setGcmSenderId("69567268823")
//                // setDatabaseURL(...)
//                .setStorageBucket("demoapplication-anna.appspot.com")
//                .build();
//        // Initialize with secondary app
//        FirebaseApp.initializeApp(this, options, FirebaseApp.DEFAULT_APP_NAME);
//
//        // Retrieve secondary FirebaseApp
//        FirebaseApp secondary = FirebaseApp.getInstance(FirebaseApp.DEFAULT_APP_NAME);
//        LogUtils.d("====FirebaseApp.DEFAULT_APP_NAME====", secondary.getOptions().toString());
//        LogUtils.d("====FirebaseApp.DEFAULT_APP_NAME isDefaultApp====", secondary.isDefaultApp());
//
//        LogUtils.d("====", FirebaseApp.getInstance().getOptions().toString());

        //获取token  正常初始化后会自动获取token token值在 MyFirebaseMessagingService 的 onNewToken回调处
//        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
//            @Override
//            public void onComplete(@NonNull Task<String> task) {
//                LogUtils.d("====getToken: ", task.getResult());
//            }
//        });
    }
}
