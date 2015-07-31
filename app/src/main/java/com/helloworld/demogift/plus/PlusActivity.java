package com.helloworld.demogift.plus;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.helloworld.demogift.BasicInfo;
import com.helloworld.demogift.R;

/**
 * Created by YueXy on 7/30/2015.
 */
public class PlusActivity extends Activity
{
	private FragmentManager mFragmentManager;
	private FragmentTransaction mFragmentTransaction;

	private BeforeFragmentSupport beforeFragmentSupport;
	private AfterFragmenSupport afterFragmenSupport;

	private ImageView plus_back;

	private static int position = 1;

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

		beforeFragmentSupport = new BeforeFragmentSupport();
		afterFragmenSupport = new AfterFragmenSupport();

		mFragmentManager = getFragmentManager();

		mFragmentManager.beginTransaction().add(R.id.plus_content, beforeFragmentSupport).commit();
		position = 1;

		plus_back = (ImageView) findViewById(R.id.plus_back);
		plus_back.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
	}

	public void switchFragment()
	{
		//mFragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
		if (position == 1)
		{
			if (!afterFragmenSupport.isAdded())
			{
				mFragmentManager.beginTransaction().hide(beforeFragmentSupport).add(R.id.plus_content, afterFragmenSupport).commit();
			}
			else
			{
				mFragmentManager.beginTransaction().hide(beforeFragmentSupport).show(afterFragmenSupport).commit();
			}

			position = 2;
		}
		else
		{
			if (!beforeFragmentSupport.isAdded())
			{
				mFragmentManager.beginTransaction().hide(afterFragmenSupport).add(R.id.plus_content, beforeFragmentSupport).commit();
			}
			else
			{
				mFragmentManager.beginTransaction().hide(afterFragmenSupport).show(beforeFragmentSupport).commit();
			}

			position = 1;
		}
	}
}
