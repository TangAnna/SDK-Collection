package com.tang.hmspushdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "=====firebase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_getFirebaseToken).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseMessaging.getInstance().getToken()
                        .addOnCompleteListener(task -> {

                            if (!task.isSuccessful()) {
                                Log.e(TAG, "Fetching FCM registration token failed", task.getException());
                                return;
                            }
                            String result = task.getResult();
                            Log.e(TAG, "Fetching FCM registration token:" + result);
                        });
            }
        });
    }
}