package com.helloworld.demogift.alarm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.helloworld.demogift.R;

import tools.AlarmTools;
import tools.SharedPreferencesTools;
import tools.ToastTools;

/**
 * Created by YueXy on 7/30/2015.
 */
public class AlarmEditActivity extends Activity
{
	private static final String TAG = "AlarmEditActivity";

	private TimePicker timePicker;
	private TextView cancel;
	private TextView save;

	private int alarm_hour;
	private int alarm_min;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarm_edit_layout);

		init();
	}

	private void init()
	{
		findViews();

		timePicker.setIs24HourView(true);
		timePicker.setCurrentHour(SharedPreferencesTools.getInstance().getAlarmHour());
		timePicker.setCurrentMinute(SharedPreferencesTools.getInstance().getAlarmMin());
		alarm_hour = timePicker.getCurrentHour();
		alarm_min = timePicker.getCurrentMinute();
		timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener()
		{
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute)
			{
				alarm_hour = hourOfDay;
				alarm_min = minute;
			}
		});

		cancel.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});

		save.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				SharedPreferencesTools.getInstance().setAlarmHour(alarm_hour);
				SharedPreferencesTools.getInstance().setAlarmMin(alarm_min);
				ToastTools.showToast(AlarmEditActivity.this, getResources().getString(R.string.alarm_edit_saved));
				AlarmTools.setAlarm();
				finish();
			}
		});
	}

	private void findViews()
	{
		timePicker = (TimePicker) findViewById(R.id.alarm_edit_timePicker);
		cancel = (TextView) findViewById(R.id.alarm_edit_cancel);
		save = (TextView) findViewById(R.id.alarm_edit_save);
	}

	@Override
	public void finish()
	{
		super.finish();
		overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
	}
}
