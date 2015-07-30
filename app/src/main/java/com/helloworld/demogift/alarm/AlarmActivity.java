package com.helloworld.demogift.alarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.helloworld.demogift.R;
import com.helloworld.demogift.views.AlarmCheckBox;

import tools.AlarmTools;
import tools.SharedPreferencesTools;
import tools.ToastTools;

/**
 * Created by YueXy on 7/30/2015.
 */
public class AlarmActivity extends Activity
{
	private static final String TAG = "AlarmActivity";

	private int[] ids = {R.id.alarm_check_box_mon, R.id.alarm_check_box_tues,
						R.id.alarm_check_box_wed, R.id.alarm_check_box_thur,
						R.id.alarm_check_box_fri, R.id.alarm_check_box_sat,
						R.id.alarm_check_box_sun};
	private AlarmCheckBox[] checkBoxes = new AlarmCheckBox[7];

	private ImageView back;
	private TextView edit;
	private TextView alarmTime;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarm_layout);

		init();
	}

	private void init()
	{
		findViews();
		//

		checkBoxes[0].setCheck(SharedPreferencesTools.getInstance().getCheckedMon());
		checkBoxes[1].setCheck(SharedPreferencesTools.getInstance().getCheckedTues());
		checkBoxes[2].setCheck(SharedPreferencesTools.getInstance().getCheckedWed());
		checkBoxes[3].setCheck(SharedPreferencesTools.getInstance().getCheckedThur());
		checkBoxes[4].setCheck(SharedPreferencesTools.getInstance().getCheckedFri());
		checkBoxes[5].setCheck(SharedPreferencesTools.getInstance().getCheckedSat());
		checkBoxes[6].setCheck(SharedPreferencesTools.getInstance().getCheckedSun());

		back.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});

		edit.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(AlarmActivity.this, AlarmEditActivity.class));
				overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
				finish();
			}
		});

		int hour = SharedPreferencesTools.getInstance().getAlarmHour();
		int min = SharedPreferencesTools.getInstance().getAlarmMin();
		String hour_str = hour < 10 ? "0" + hour : "" + hour;
		String min_str = min < 10 ? "0" + min : "" + min;

		alarmTime.setText(hour_str + ":" + min_str);

		setCheckBoxesListener();
	}

	private void findViews()
	{
		for (int i = 0; i < 7; i++)
		{
			checkBoxes[i] = (AlarmCheckBox) findViewById(ids[i]);
		}

		back = (ImageView) findViewById(R.id.alarm_back);
		edit = (TextView) findViewById(R.id.alarm_edit);
		alarmTime = (TextView) findViewById(R.id.alarm_time);
	}

	private void setCheckBoxesListener()
	{
		checkBoxes[0].setOnCheckListener(new AlarmCheckBox.OnCheckListener()
		{
			@Override
			public void onCheck(boolean b)
			{
				SharedPreferencesTools.getInstance().setCheckedMon(b);
			}
		});

		checkBoxes[1].setOnCheckListener(new AlarmCheckBox.OnCheckListener()
		{
			@Override
			public void onCheck(boolean b)
			{
				SharedPreferencesTools.getInstance().setCheckedTues(b);
			}
		});

		checkBoxes[2].setOnCheckListener(new AlarmCheckBox.OnCheckListener()
		{
			@Override
			public void onCheck(boolean b)
			{
				SharedPreferencesTools.getInstance().setCheckedWed(b);
			}
		});

		checkBoxes[3].setOnCheckListener(new AlarmCheckBox.OnCheckListener()
		{
			@Override
			public void onCheck(boolean b)
			{
				SharedPreferencesTools.getInstance().setCheckedThur(b);
			}
		});

		checkBoxes[4].setOnCheckListener(new AlarmCheckBox.OnCheckListener()
		{
			@Override
			public void onCheck(boolean b)
			{
				SharedPreferencesTools.getInstance().setCheckedFri(b);
			}
		});

		checkBoxes[5].setOnCheckListener(new AlarmCheckBox.OnCheckListener()
		{
			@Override
			public void onCheck(boolean b)
			{
				SharedPreferencesTools.getInstance().setCheckedSat(b);
			}
		});

		checkBoxes[6].setOnCheckListener(new AlarmCheckBox.OnCheckListener()
		{
			@Override
			public void onCheck(boolean b)
			{
				SharedPreferencesTools.getInstance().setCheckedSun(b);
			}
		});
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		AlarmTools.setAlarm();
//		ToastTools.showToast(AlarmActivity.this, getResources().getString(R.string.alarm_edit_saved));
	}
}
