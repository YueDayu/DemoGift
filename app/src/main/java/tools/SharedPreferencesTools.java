package tools;

import android.content.SharedPreferences;

import com.helloworld.demogift.BasicInfo;
import com.helloworld.demogift.MyApplication;

/**
 * Created by YueXy on 7/30/2015.
 */
public class SharedPreferencesTools
{
	private static final String TAG = "SharedPreferencesTools";
	private static SharedPreferencesTools sharedPreferencesTools;

	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor editor;

	public static SharedPreferencesTools getInstance()
	{
		if (sharedPreferencesTools == null)
			sharedPreferencesTools = new SharedPreferencesTools();

		return sharedPreferencesTools;
	}

	private SharedPreferencesTools()
	{
		sharedPreferences = MyApplication.getInstance().getSharedPreferences(BasicInfo.SPID, 0);
		editor = sharedPreferences.edit();
	}

	public void setAlarmHour(int hour)
	{
		editor.putInt(BasicInfo.ALARM_HOUR, hour);
		editor.commit();
	}

	public int getAlarmHour()
	{
		return sharedPreferences.getInt(BasicInfo.ALARM_HOUR, 0);
	}

	public void setAlarmMin(int min)
	{
		editor.putInt(BasicInfo.ALARM_MIN, min);
		editor.commit();
	}

	public int getAlarmMin()
	{
		return sharedPreferences.getInt(BasicInfo.ALARM_MIN, 0);
	}

	public void setCheckedMon(boolean b)
	{
		editor.putBoolean(BasicInfo.ALARM_CHECKED_MON, b);
		editor.commit();
	}

	public boolean getCheckedMon()
	{
		return sharedPreferences.getBoolean(BasicInfo.ALARM_CHECKED_MON, false);
	}

	public void setCheckedTues(boolean b)
	{
		editor.putBoolean(BasicInfo.ALARM_CHECKED_TUES, b);
		editor.commit();
	}

	public boolean getCheckedTues()
	{
		return sharedPreferences.getBoolean(BasicInfo.ALARM_CHECKED_TUES, false);
	}

	public void setCheckedWed(boolean b)
	{
		editor.putBoolean(BasicInfo.ALARM_CHECKED_WED, b);
		editor.commit();
	}

	public boolean getCheckedWed()
	{
		return sharedPreferences.getBoolean(BasicInfo.ALARM_CHECKED_WED, false);
	}

	public void setCheckedThur(boolean b)
	{
		editor.putBoolean(BasicInfo.ALARM_CHECKED_THUR, b);
		editor.commit();
	}

	public boolean getCheckedThur()
	{
		return sharedPreferences.getBoolean(BasicInfo.ALARM_CHECKED_THUR, false);
	}

	public void setCheckedFri(boolean b)
	{
		editor.putBoolean(BasicInfo.ALARM_CHECKED_FRI, b);
		editor.commit();
	}

	public boolean getCheckedFri()
	{
		return sharedPreferences.getBoolean(BasicInfo.ALARM_CHECKED_FRI, false);
	}

	public void setCheckedSat(boolean b)
	{
		editor.putBoolean(BasicInfo.ALARM_CHECKED_SAT, b);
		editor.commit();
	}

	public boolean getCheckedSat()
	{
		return sharedPreferences.getBoolean(BasicInfo.ALARM_CHECKED_SAT, false);
	}

	public void setCheckedSun(boolean b)
	{
		editor.putBoolean(BasicInfo.ALARM_CHECKED_SUN, b);
		editor.commit();
	}

	public boolean getCheckedSun()
	{
		return sharedPreferences.getBoolean(BasicInfo.ALARM_CHECKED_SUN, false);
	}

	public void setMainEyes(boolean b)
	{
		editor.putBoolean(BasicInfo.MAIN_EYES, b);
		editor.commit();
	}

	public boolean getMainEyes()
	{
		return sharedPreferences.getBoolean(BasicInfo.MAIN_EYES, false);
	}
}
