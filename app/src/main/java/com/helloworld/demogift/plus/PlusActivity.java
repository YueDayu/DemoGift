package com.helloworld.demogift.plus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.helloworld.demogift.BasicInfo;
import com.helloworld.demogift.R;

/**
 * Created by YueXy on 7/30/2015.
 */
public class PlusActivity extends FragmentActivity
{
	private FragmentManager mFragmentManager;

	private BeforeFragmentSupport beforeFragmentSupport;
	private AfterFragmenSupport afterFragmenSupport;

	private ImageView plus_back;
	private ImageView plus_menu;

	private PopupWindow popupWindow;

	private TextView plus_title;

	private static int position = 1;

	public int local = 0;

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

		plus_title = (TextView) findViewById(R.id.plus_title);
		plus_menu = (ImageView) findViewById(R.id.plus_menu);

		initPopupWindow();

		beforeFragmentSupport = new BeforeFragmentSupport();
		afterFragmenSupport = new AfterFragmenSupport();

		mFragmentManager = getSupportFragmentManager();

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

		plus_menu.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (popupWindow.isShowing())
					popupWindow.dismiss();
				else
					popupWindow.showAsDropDown(plus_menu, 0, 30);
			}
		});
	}

	public void switchFragment()
	{
		//mFragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
		plus_title.setText(1 + local + "/450");
		if (position == 1)
		{
			if (!afterFragmenSupport.isAdded())
			{
				mFragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).hide(beforeFragmentSupport).add(R.id.plus_content, afterFragmenSupport).commit();
			}
			else
			{
				mFragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).hide(beforeFragmentSupport).show(afterFragmenSupport).commit();
			}
			if (local > 0)
				afterFragmenSupport.setImage();

			position = 2;
		}
		else
		{
			if (!beforeFragmentSupport.isAdded())
			{
				mFragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).hide(afterFragmenSupport).add(R.id.plus_content, beforeFragmentSupport).commit();
			}
			else
			{
				mFragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).hide(afterFragmenSupport).show(beforeFragmentSupport).commit();
			}
			beforeFragmentSupport.setImage();

			position = 1;
		}
	}

	private void initPopupWindow()
	{
		LayoutInflater layoutInflater = getLayoutInflater();
		View layout = layoutInflater.inflate(R.layout.plus_menu, null);
		popupWindow = new PopupWindow(layout);
		popupWindow.setFocusable(true);        // 接收事件

		layout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
		popupWindow.setHeight(layout.getMeasuredHeight());
		popupWindow.setWidth(layout.getMeasuredWidth());

		popupWindow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.word_menu));
		popupWindow.setOutsideTouchable(true);
	}
}
