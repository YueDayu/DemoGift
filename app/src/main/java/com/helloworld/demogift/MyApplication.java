package com.helloworld.demogift;

import android.app.Application;

import tools.TypefaceTools;

/**
 * Created by YueXy on 7/30/2015.
 */
public class MyApplication extends Application
{
	private static final String TAG = "MyApplication";

	private static MyApplication myApplication = null;

	public static MyApplication getInstance()
	{
		return myApplication;
	}

	@Override
	public void onCreate()
	{
		super.onCreate();
		myApplication = this;

		init();
	}

	private void init()
	{
		TypefaceTools.getBoldTypeface();
	}
}
