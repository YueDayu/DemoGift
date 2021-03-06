package com.helloworld.demogift;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.gc.materialdesign.views.ButtonFlatWithIcon;
import com.helloworld.demogift.alarm.AlarmActivity;
import com.helloworld.demogift.demo.DemoActivity;
import com.helloworld.demogift.laction.LocationActivity;
import com.helloworld.demogift.more.MoreActivity;
import com.helloworld.demogift.plus.PlusActivity;
import com.helloworld.demogift.select.SelectActivity;

import tools.SharedPreferencesTools;

public class MainActivity extends Activity implements View.OnClickListener
{
	private static final String TAG = "MainActivity";

	private static final int LOCATION_ID = R.id.demo_main_location;
	private static final int PLUS_ID = R.id.demo_main_button_plus;
	private static final int ALARM_ID = R.id.demo_main_button_alarm;
	private static final int SELECT_ID = R.id.demo_main_button_select;
	private static final int MORE_ID = R.id.demo_main_button_more;
	private static final int DEMO_ID = R.id.demo_main_button_demo;

	private static final int duration = 2000;

	private ImageView location;
	private ImageView plus;

	private ButtonFlatWithIcon alarm;
	private ButtonFlatWithIcon select;
	private ButtonFlatWithIcon more;
	private ButtonFlatWithIcon demo;

	private ImageView eye;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();
	}

	private void init()
	{
		findViews();

		alarm.setOnClickListener(this);
		select.setOnClickListener(this);
		more.setOnClickListener(this);
		demo.setOnClickListener(this);
		location.setOnClickListener(this);
		plus.setOnClickListener(this);

		checkEye();
	}

	private void findViews()
	{
		location = (ImageView) findViewById(LOCATION_ID);
		plus = (ImageView) findViewById(PLUS_ID);

		alarm = (ButtonFlatWithIcon) findViewById(ALARM_ID);
		select = (ButtonFlatWithIcon) findViewById(SELECT_ID);
		more = (ButtonFlatWithIcon) findViewById(MORE_ID);
		demo = (ButtonFlatWithIcon) findViewById(DEMO_ID);

		eye = (ImageView) findViewById(R.id.demo_main_eyes);
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case ALARM_ID:
			startActivity(new Intent(MainActivity.this, AlarmActivity.class));
			break;

		case SELECT_ID:
			startActivity(new Intent(MainActivity.this, SelectActivity.class));
			break;

		case PLUS_ID:
			startActivity(new Intent(MainActivity.this, PlusActivity.class));
			break;

		case MORE_ID:
			startActivity(new Intent(MainActivity.this, MoreActivity.class));
			break;

		case DEMO_ID:
			startActivity(new Intent(MainActivity.this, DemoActivity.class));
			break;

		case LOCATION_ID:
			startActivity(new Intent(MainActivity.this, LocationActivity.class));
			overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
			break;
		}
	}

	@Override
	protected void onResume()
	{
		super.onResume();

		checkEye();
	}

	private void checkEye()
	{
		boolean isEye = SharedPreferencesTools.getInstance().getMainEyes();

		if (isEye && eye.getScaleY() > 0)
		{
			eye.setPivotY(1.0f);
			eye.setPivotX(1.0f);
			final ObjectAnimator scaleYs = ObjectAnimator.ofFloat(eye, "scaleY", 0).setDuration(duration);
			scaleYs.setInterpolator(new DecelerateInterpolator());
			scaleYs.start();
		}

		SharedPreferencesTools.getInstance().setMainEyes(false);
	}
}
