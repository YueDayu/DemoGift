package com.helloworld.demogift.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gc.materialdesign.views.CheckBox;
import com.helloworld.demogift.R;

import tools.TypefaceTools;

/**
 * Created by YueXy on 7/30/2015.
 */
public class 	AlarmCheckBox extends FrameLayout
{
	private static final String TAG = "AlarmCheckBox";
	private static final String ANDROIDXML = "http://schemas.android.com/apk/res/android";

	private String text;
	private Context mContext;
	private ImageView imageView;
	private TextView textView;

	private boolean check;
	private OnCheckListener onCheckListener = null;

	public AlarmCheckBox(Context context)
	{
		this(context, null);
	}

	public AlarmCheckBox(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		mContext = context;
		handleAttributes(attrs);
	}

	public AlarmCheckBox(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		mContext = context;
		handleAttributes(attrs);
	}

	private void handleAttributes(AttributeSet attrs)
	{
		text = null;
		int textResource = attrs.getAttributeResourceValue(ANDROIDXML, "text", -1);
		if (textResource != -1)
		{
			text = getResources().getString(textResource);
		}
		else
		{
			text = attrs.getAttributeValue(ANDROIDXML, "text");
		}
	}

	@Override
	protected void onFinishInflate()
	{
		super.onFinishInflate();
		addView(LayoutInflater.from(mContext).inflate(R.layout.alarm_check_box, this, false));

		imageView = (ImageView) findViewById(R.id.alarm_check_box_bg);
		textView = (TextView) findViewById(R.id.alarm_check_box_tx);

		textView.setText(text);
		textView.setTextColor(getResources().getColor(R.color.gold));

		if (!isInEditMode())
			textView.setTypeface(TypefaceTools.getBoldTypeface());

		imageView.setImageResource(R.mipmap.demo_alarm_day_unselected);

		check = false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		if (event.getAction() == MotionEvent.ACTION_DOWN && event.getX() <= getWidth() && event.getX() > 0 && event.getY() <= getHeight() && event.getY() > 0)
		{
			check = !check;
			changeState(check);

			if (this.onCheckListener != null)
			{
				onCheckListener.onCheck(check);
			}

			return true;
		}
		return false;
	}

	private void changeState(boolean b)
	{
		if (b)
		{
			textView.setTextColor(getResources().getColor(R.color.white));
			imageView.setImageResource(R.mipmap.demo_alarm_day_selected);
		}
		else
		{
			textView.setTextColor(getResources().getColor(R.color.gold));
			imageView.setImageResource(R.mipmap.demo_alarm_day_unselected);
		}
	}

	public void check(boolean b)
	{
		check = b;
		changeState(b);

		if (this.onCheckListener != null)
		{
			onCheckListener.onCheck(check);
		}
	}

	public void setCheck(boolean b)
	{
		check = b;
		changeState(b);
	}

	public boolean isChecked()
	{
		return check;
	}

	public void setOnCheckListener(OnCheckListener o)
	{
		this.onCheckListener = o;
	}

	public interface OnCheckListener
	{
		public void onCheck(boolean b);
	}
}
