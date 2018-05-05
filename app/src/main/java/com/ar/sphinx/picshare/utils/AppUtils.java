package com.ar.sphinx.picshare.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sPhinx on 14/03/18.
 */

public class AppUtils {

	public static void LogMsgUtil(String tag,String msg){
		Log.d(tag,msg);
		Log.v(tag,msg);
	}

	public static void showAtoast(String msg,Context context){
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
}
