package com.eobiet.app.freakingmath;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtil {

	public static void setValue(Context ctx, String key, String val){
		SharedPreferences pref = ctx.getSharedPreferences("FM", 0);
		SharedPreferences.Editor edit = pref.edit();
		edit.putString(key, val);
		edit.commit();
	}
	
	public static void setValue(Context ctx, String key, int val){
		SharedPreferences pref = ctx.getSharedPreferences("FM", 0);
		SharedPreferences.Editor edit = pref.edit();
		edit.putInt(key, val);
		edit.commit();
	}
	
	public static int getValue(Context ctx, String key, int delVal){
		SharedPreferences pref = ctx.getSharedPreferences("FM", 0);
		return pref.getInt(key, delVal);
	}
	public static String getValue(Context ctx, String key, String delVal){
		SharedPreferences pref = ctx.getSharedPreferences("FM", 0);
		return pref.getString(key, delVal);
	}
	public static void removeValue(Context ctx, String key){
		SharedPreferences settings = ctx.getSharedPreferences("FM", 0);
		SharedPreferences.Editor edit = settings.edit();
		edit.remove(key).commit();
	}
	
	
}
