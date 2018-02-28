package com.example.litianci.guangming;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.litianci.guangming.bean.Notify;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.home.FileCirculationXQActivity;
import com.example.litianci.guangming.notice.NoticeXQActivity;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.xiangqing.DaibanXQActivity;
import com.example.litianci.guangming.xiangqing.DataXQActivity;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushManager;


public class PushDemoReceiver extends BroadcastReceiver {

    /**
     * 应用未启动, 个推 service已经被唤醒,保存在该时间段内离线消息(此时 GetuiSdkDemoActivity.tLogView == null)
     */
    public static StringBuilder payloadData = new StringBuilder();
    public static String taskid;
    public static String messageid;
    private Bitmap icon;

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        Log.i("GetuiSdkDemo", bundle.toString());
        Log.d("GetuiSdkDemo", "onReceive() action=" + bundle.getInt("action"));

        switch (bundle.getInt(PushConsts.CMD_ACTION)) {
            case PushConsts.GET_MSG_DATA:
                // 获取透传数据
                // String appid = bundle.getString("appid");
                Log.i("GetuiSdkDemo", bundle.toString());
                byte[] payload = bundle.getByteArray("payload");

                taskid = bundle.getString("taskid");
                messageid = bundle.getString("messageid");

                // smartPush第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
                boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskid, messageid, 90001);
                System.out.println("第三方回执接口调用" + (result ? "成功" : "失败"));

                if (payload != null) {
                    String data = new String(payload);

                    Log.i("GetuiSdkDemo", "receiver payload : " + data);
                    payloadData.append(data);
                    payloadData.append("\n");

                    Log.i("推送消息", "receiver payload : " + payloadData);
                    Notify s1 = GsonUtils.json2bean(data,
                            Notify.class);
                    //更新日志信息
//                    if (GetuiSdkDemoActivity.tLogView != null) {
//                        GetuiSdkDemoActivity.tLogView.append(data + "\n");
//                    }
                    icon = BitmapFactory.decodeResource(context.getResources(),
                            R.mipmap.ic_launcher);
                    NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
                    mBuilder.setContentTitle("光明街道") //<span style="font-family: Arial;">/设置通知栏显示内容</span>
                            .setContentIntent(getDefalutIntent(context, PendingIntent.FLAG_UPDATE_CURRENT, s1.getTYPE(), s1.getID())) //设置通知栏点击意图
                            //  .setNumber(number) //设置通知集合的数量
                            .setTicker("有新消息了").setContentText(s1.getMESSAGE()) //通知首次出现在通知栏，带上升动画效果的
                            .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                            .setPriority(Notification.PRIORITY_DEFAULT) //设置该通知优先级
                            //  .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                            .setOngoing(false)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                            .setDefaults(Notification.DEFAULT_SOUND)//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合
                            //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND 添加声音 // requires VIBRATE permission
                            .setSmallIcon(R.mipmap.tubiao)//设置通知小ICON
                            .setLargeIcon(icon)
                            .setAutoCancel(true)
                    ;
//                    mBuilder.build().flags|= Notification.FLAG_AUTO_CANCEL;
                    if (s1.getID().contains(",")) {
                        mNotificationManager.notify(Integer.parseInt(s1.getID().split(",")[0]), mBuilder.build());
                    } else {
                        mNotificationManager.notify(Integer.parseInt(s1.getID()), mBuilder.build());
                    }

//                    mNotificationManager.cancel(1);
                }

                break;

            case PushConsts.GET_CLIENTID:
                // 获取ClientID(CID)
                // 第三方应用需要将CID上传到第三方服务器，并且将当前用户帐号和CID进行关联，以便日后通过用户帐号查找CID进行消息推送
                String cid = bundle.getString("clientid");
                Log.i("zhang", "我的cid是：" + cid);
                User.Cid = cid;
                //更新ClientID(CID)
//                if (GetuiSdkDemoActivity.tView != null) {
//                    GetuiSdkDemoActivity.tView.setText(cid);
//                }
                break;

            case PushConsts.THIRDPART_FEEDBACK:
                /*
                 * String appid = bundle.getString("appid"); String taskid =
                 * bundle.getString("taskid"); String actionid = bundle.getString("actionid");
                 * String result = bundle.getString("result"); long timestamp =
                 * bundle.getLong("timestamp");
                 *
                 * Log.d("GetuiSdkDemo", "appid = " + appid); Log.d("GetuiSdkDemo", "taskid = " +
                 * taskid); Log.d("GetuiSdkDemo", "actionid = " + actionid); Log.d("GetuiSdkDemo",
                 * "result = " + result); Log.d("GetuiSdkDemo", "timestamp = " + timestamp);
                 */
                break;

            default:
                break;
        }
    }

    public PendingIntent getDefalutIntent(Context context, int flags, String type, String id) {
        Intent intent5 = null;

        if (type.equals("资料传送")) {
            intent5 = new Intent(context, DataXQActivity.class);
            intent5.putExtra("id", id);
            intent5.putExtra("ac", "SzlD");

        }
        if (type.equals("待办工作")) {
            intent5 = new Intent(context, DaibanXQActivity.class);
            intent5.putExtra("type", "待办工作");
            intent5.putExtra("id", id.split(",")[0]);
            intent5.putExtra("inid", id.split(",")[1]);

        }
        if (type.equals("通知公告")) {
            intent5 = new Intent(context, NoticeXQActivity.class);
            intent5.putExtra("id", id);

        }
        if (type.equals("文件传阅")) {
            intent5 = new Intent(context, FileCirculationXQActivity.class);
            intent5.putExtra("state", "1");
            intent5.putExtra("id", id);

        }
//        if (s1.equals("2")) {
//            intent5 = new Intent(context, TzGgXqActivity.class);
//            intent5.putExtra(Globals.XXRID, zhuid);
//            intent5.putExtra(Globals.XXCID, cid);
//
//        }
//        if (s1.equals("3")) {
//            intent5 = new Intent(context, TzGgXqActivity.class);
//            intent5.putExtra(Globals.XXRID, zhuid);
//            intent5.putExtra(Globals.XXCID, cid);
//
//
//        }
//        if (s1.equals("5")) {
//            intent5 = new Intent(context, TzGgXqActivity.class);
//            intent5.putExtra(Globals.XXRID, zhuid);
//            intent5.putExtra(Globals.XXCID, cid);
//
//        }
//        if (s1.equals("6")) {
//            intent5 = new Intent(context, FileCircularizeActivity.class);
//            intent5.putExtra(Globals.XXRID, zhuid);
//            intent5.putExtra(Globals.XXCID, cid);
//        }
//        if (s1.equals("7")) {
//            intent5 = new Intent(context, DuChaXqActivity.class);
//            intent5.putExtra(Globals.XXRID, zhuid);
//        }
//        if (s1.equals("8")) {
//            intent5 = new Intent(context, DuChaXq3Activity.class);
//            intent5.putExtra(Globals.XXRID, zhuid);
//        }
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent5, flags);
        return pendingIntent;
    }

}