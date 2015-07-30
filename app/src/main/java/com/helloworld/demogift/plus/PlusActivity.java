package com.helloworld.demogift.plus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.helloworld.demogift.BasicInfo;
import com.helloworld.demogift.R;

/**
 * Created by YueXy on 7/30/2015.
 */
public class PlusActivity extends Activity
{
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.plus_layout);

		init();
	}

	private void init()
	{
		//
		Intent intent = getIntent();
		String extra = intent.getStringExtra(BasicInfo.LAUNCH_ACTIVITY);
		if (extra == null)
			System.out.println("null");
		else
			System.out.println(extra);
	}
}
