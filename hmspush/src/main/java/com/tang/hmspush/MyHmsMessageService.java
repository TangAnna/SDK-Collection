package com.tang.hmspush;

import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;

public class MyHmsMessageService extends HmsMessageService {

    public static final String TAG = "=====hms";

    @Override
    public void onNewToken(String token) {
        //正常集成成功后会自动完成默认的初始化在这里得到 推送 token
        LogUtils.i(TAG, "received refresh token:" + token);
        refreshedTokenToServer(token);
    }


    /**
     * 更新服务端保存的token
     *
     * @param token 更新后的token
     */
    private void refreshedTokenToServer(String token) {
        //token 必须做判空处理
        if (!TextUtils.isEmpty(token)) {
            //这里实现更新服务端token
        }

    }

    /**
     * 收到推送过来的token回调
     *
     * @param message
     */
    @Override
    public void onMessageReceived(RemoteMessage message) {
        super.onMessageReceived(message);
        if (message == null) {
            LogUtils.e(TAG, "Received message entity is null!");
            return;
        }

        // 获取消息内容
        LogUtils.i(TAG, "Received message information："
                + "\n get Data: " + message.getData()
                + "\n getFrom: " + message.getFrom()
                + "\n getTo: " + message.getTo()
                + "\n getMessageId: " + message.getMessageId()
                + "\n getSentTime: " + message.getSentTime()
                + "\n getDataMap: " + message.getDataOfMap()
                + "\n getMessageType: " + message.getMessageType()
                + "\n getTtl: " + message.getTtl()
                + "\n getToken: " + message.getToken());


    }
}
