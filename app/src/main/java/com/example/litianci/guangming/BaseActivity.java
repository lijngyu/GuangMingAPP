package com.example.litianci.guangming;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;


/**
 * 创建的布局是没有bar的activity（所有activity的父类）
 *
 * @author ZJP
 *         created at 2016/4/28 13:45
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onStop() {
        super.onStop();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        RequestManager.cancelAll(this);
    }


    @Override
    protected void onRestart() {
//		Log.i("zhang____", "这时的是不是在后台"+Globals.isActive);
//		if(SharedPreferencesUtils.getString(BaseActivity.this, Globals.MM_XC, "0").equals("1")){
//			if(Globals.isActive){
//
//			}else{
//
//				finish();
//			}
//		}

        super.onRestart();
    }

    /**
     *判断当前应用程序处于前台还是后台
     */
//	public static boolean isApplicationBroughtToBackground(final Context context) {
//		ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
//		List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
//		if (!tasks.isEmpty()) {
//			ComponentName topActivity = tasks.get(0).topActivity;
//			if (!topActivity.getPackageName().equals(context.getPackageName())) {
//				return true;
//			}
//		}
//		return false;
//	}
}
