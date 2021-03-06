package com.example.litianci.guangming.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtils {

	public static String SP_NAME = "config";
	private static SharedPreferences sp;

	public static void saveBoolean(Context context, String key, boolean value) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		sp.edit().putBoolean(key, value).commit();
	}

	public static boolean getBoolean(Context context,String key,boolean defValue){
		if(sp == null) {
			sp = context.getSharedPreferences(SP_NAME, 0);
		
		}
		return sp.getBoolean(key, defValue);
	}
	
	public static void saveString(Context context, String key, String value) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);

		sp.edit().putString(key, value).commit();
	}
	public static void removeString(Context context, String key) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);

		sp.edit().remove(key).commit();
	}
	public static void clearString(Context context) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);

		sp.edit().clear().commit();
	}

	public static String getString(Context context,String key,String defValue){
		if(sp == null) {
			sp = context.getSharedPreferences(SP_NAME, 0);
		
		}
		return sp.getString(key, defValue);
	}
	/**
	 * 查询某个key是否已经存在
	 * @param context
	 * @param key
	 * @return
	 */
	public static boolean contains(Context context, String key)
	{
		SharedPreferences sp = context.getSharedPreferences(SP_NAME,
				0);
		return sp.contains(key);
	}


}
