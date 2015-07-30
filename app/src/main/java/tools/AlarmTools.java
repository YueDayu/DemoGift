package tools;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.helloworld.demogift.MyApplication;
import com.helloworld.demogift.alarm.AlarmReceiver;

import java.util.Calendar;

/**
 * Created by YueXy on 7/30/2015.
 */
public class AlarmTools
{
	private static final String TAG = "AlarmTools";

	public static PendingIntent[] sender = new PendingIntent[7];

	public static void setAlarm()
	{
		Intent intent = new Intent(MyApplication.getInstance(), AlarmReceiver.class);

		for (int i = 0; i < 7; i++)
		{
			if (sender[i] == null)
				sender[i] = PendingIntent.getBroadcast(MyApplication.getInstance(), i, intent, 0);
		}

		boolean[] days = new boolean[7];
		days[0] = SharedPreferencesTools.getInstance().getCheckedMon();
		days[1] = SharedPreferencesTools.getInstance().getCheckedTues();
		days[2] = SharedPreferencesTools.getInstance().getCheckedWed();
		days[3] = SharedPreferencesTools.getInstance().getCheckedThur();
		days[4] = SharedPreferencesTools.getInstance().getCheckedFri();
		days[5] = SharedPreferencesTools.getInstance().getCheckedSat();
		days[6] = SharedPreferencesTools.getInstance().getCheckedSun();

		int[] days_of_week = {Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY,
								Calendar.SATURDAY, Calendar.SUNDAY};

		int hour = SharedPreferencesTools.getInstance().getAlarmHour();
		int min = SharedPreferencesTools.getInstance().getAlarmMin();

		AlarmManager alarmManager = (AlarmManager) MyApplication.getInstance().getSystemService(Context.ALARM_SERVICE);

		Calendar calendar = Calendar.getInstance();

		long now = calendar.getTimeInMillis();

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		for (int i = 0; i < 7; i++)
		{
			if (days[i])
			{
				// set
				calendar.set(Calendar.DAY_OF_WEEK, days_of_week[i]);
				if (calendar.getTimeInMillis() > now)
				{
					// 从本周开始
					alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),  (7*24*60*60*1000), sender[i]);
				}
				else
				{
					// 从下周开始
					alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + (7*24*60*60*1000),  (7*24*60*60*1000), sender[i]);
				}
			}
			else
			{
				// cancel
				alarmManager.cancel(sender[i]);
			}
		}
	}
}
