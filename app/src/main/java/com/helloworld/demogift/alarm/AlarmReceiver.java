package com.helloworld.demogift.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.helloworld.demogift.BasicInfo;
import com.helloworld.demogift.plus.PlusActivity;

/**
 * Created by YueXy on 7/30/2015.
 */
public class AlarmReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent)
	{
		//
		Intent i = new Intent(context, PlusActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.putExtra(BasicInfo.LAUNCH_ACTIVITY, BasicInfo.ALARM_RECEIVER);
		context.startActivity(i);
	}
}
