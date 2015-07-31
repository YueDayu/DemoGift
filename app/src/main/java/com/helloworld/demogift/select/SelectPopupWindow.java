package com.helloworld.demogift.select;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.PopupWindow;

import com.gc.materialdesign.views.ButtonFlat;
import com.helloworld.demogift.R;

import tools.ToastTools;

/**
 * Created by YueXy on 7/31/2015.
 */
public class SelectPopupWindow extends PopupWindow
{
	private View mainView;

	private NumberPicker selectMonth;
	private NumberPicker selectDay;
	private Button selectOK;

	public SelectPopupWindow(final Activity context, View.OnClickListener itemclick)
	{
		super(context);
		LayoutInflater inflater = LayoutInflater.from(context);
		mainView = inflater.inflate(R.layout.select_popup_view, null);

		selectMonth = (NumberPicker) mainView.findViewById(R.id.select_popup_month);
		selectDay = (NumberPicker) mainView.findViewById(R.id.select_popup_day);
		selectOK = (Button) mainView.findViewById(R.id.select_popup_ok);

		this.setWidth(LayoutParams.MATCH_PARENT);
		this.setHeight(LayoutParams.WRAP_CONTENT);
		this.setContentView(mainView);
		this.setFocusable(true);
		this.setAnimationStyle(R.style.select_popup_anim);

		selectMonth.setMinValue(0);
		selectMonth.setMaxValue(12);
		selectDay.setMinValue(0);
		selectDay.setMaxValue(30);

		selectOK.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				ToastTools.showToast(context, "选择课程成功");
				dismiss();
			}
		});
	}
}
