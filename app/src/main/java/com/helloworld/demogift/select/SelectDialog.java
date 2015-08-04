package com.helloworld.demogift.select;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.helloworld.demogift.R;

import java.util.Calendar;

import tools.ToastTools;

/**
 * Created by YueXy on 8/5/2015.
 */
public class SelectDialog extends Dialog
{
	private Context mContext;
	private String titleStr;
	private int lessonlength;

	private NumberPicker selectMonth;
	private NumberPicker selectDay;
	private Button selectOk;
	private TextView nums;
	private TextView title;

	private View rootView;

	private int selectedMonth;
	private int selectedDay;

	private long currentTime;
	private long setTime;

	private boolean setSucceed;

	private Calendar calendar;

	public SelectDialog(Context context, String t, int n)
	{
		this(context, R.style.theme_dialog, t, n);
	}

	public SelectDialog(Context context, int theme, String t, int n)
	{
		super(context, theme);

		mContext = context;
		titleStr = t;
		lessonlength = n;
	}


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		LayoutInflater layoutInflater = LayoutInflater.from(mContext);
		rootView = layoutInflater.inflate(R.layout.select_popup_view, null);

		setContentView(rootView);

		init();
	}

	private void init()
	{
		findViews();

		calendar = Calendar.getInstance();

		currentTime = calendar.getTimeInMillis();

		selectMonth.setMinValue(1);
		selectMonth.setMaxValue(12);
		selectDay.setMinValue(1);
		selectDay.setMaxValue(getMonthDay(calendar.get(Calendar.MONTH)));

		selectMonth.setValue(calendar.get(Calendar.MONTH) + 1);
		selectDay.setValue(calendar.get(Calendar.DAY_OF_MONTH));
		nums.setText("--");
		title.setText(titleStr);
		setSucceed = false;

		selectedMonth = calendar.get(Calendar.MONTH);
		selectedDay = calendar.get(Calendar.DAY_OF_MONTH);

		selectOk.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (setSucceed)
				{
					ToastTools.showToast((Activity) mContext, "选择课程成功");
					dismiss();
				}
				else
				{
					ToastTools.showToast((Activity) mContext, "输入错误");
				}
			}
		});

		selectMonth.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
		{
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal)
			{
				selectedMonth = newVal - 1;
				calendar.set(Calendar.MONTH, selectedMonth);
				selectDay.setMaxValue(getMonthDay(calendar.get(Calendar.MONTH)));

				calendar.set(Calendar.DAY_OF_MONTH, selectDay.getValue());

				setTime = calendar.getTimeInMillis();

				setText();
			}
		});

		selectDay.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
		{
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal)
			{
				selectedDay = newVal;

				calendar.set(Calendar.DAY_OF_MONTH, selectedDay);

				setTime = calendar.getTimeInMillis();

				setText();
			}
		});
	}

	private void findViews()
	{
		selectMonth = (NumberPicker) rootView.findViewById(R.id.select_popup_month);
		selectDay = (NumberPicker) rootView.findViewById(R.id.select_popup_day);
		selectOk = (Button) rootView.findViewById(R.id.select_popup_ok);
		nums = (TextView) rootView.findViewById(R.id.word_num);
		title = (TextView) rootView.findViewById(R.id.select_popup_title);
	}

	private int getMonthDay(int m)
	{
		Calendar a = Calendar.getInstance();
		a.set(Calendar.MONTH, m);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	private void setText()
	{
		if (setTime <= currentTime)
		{
			nums.setText("--");
			setSucceed = false;
		}
		else
		{
			long dayNum = (setTime - currentTime) / (24 * 60 * 60 * 1000);

			int num = lessonlength / (int) dayNum;

			nums.setText(num + "");

			setSucceed = true;
		}
	}
}
