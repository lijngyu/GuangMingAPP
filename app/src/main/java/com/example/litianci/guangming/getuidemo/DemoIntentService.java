package com.example.litianci.guangming.getuidemo;

import android.content.Context;
import android.os.Message;
import android.util.Log;

import com.example.litianci.guangming.bean.User;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;

/**
 * Created by litianci on 2018/1/3.
 */

public class DemoIntentService extends GTIntentService {


    public DemoIntentService() {

    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        byte[] payload = msg.getPayload();
        String appid = msg.getAppid();
        String taskid = msg.getTaskId();
        String messageid = msg.getMessageId();
        String pkg = msg.getPkgName();
        Log.d("receiver payload = ", "" + msg);
        String cid = msg.getClientId();

        // 第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
        boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskid, messageid, 90001);
        if (payload == null) {
        } else {
        }
        String data = new String(payload);
        Log.d(TAG, "receiver payload = " + data);
        try {

            sendMessage(data, 0);//这里调用方法 将透传消息发送给App类进行处理
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private void sendMessage(String data, int what) {
        Message msg = Message.obtain();
        msg.obj = data;
//        App.getInstance().sendMessage(data);//发送消息给App类进行处理
    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
        User.Cid = clientid;
        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
    }
}
