package com.helloworld.demogift.laction;

import android.app.Activity;
import android.os.Bundle;

import com.helloworld.demogift.R;

/**
 * Created by YueXy on 7/30/2015.
 */
public class LocationActivity extends Activity
{
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location_layout);

		init();
	}

	private void init()
	{
		//
	}

	@Override
	public void finish()
	{
		super.finish();
		overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
	}
}
