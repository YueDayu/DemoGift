package com.gc.materialdesign.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gc.materialdesign.R;
import com.gc.materialdesign.utils.Utils;

/**
 * Created by YueXy on 7/30/2015.
 */
public class ButtonFlatWithIcon extends Button
{
	ImageView icon;
	Drawable drawableIcon;
	int sizeIcon = 47;
	Context mContext;

	public ButtonFlatWithIcon(Context context, AttributeSet attrs)
	{
		super(context, attrs);

		mContext = context;
		setBackgroundResource(R.drawable.background_transparent);

		setDefaultProperties();
		setAttributes(attrs);

		icon = new ImageView(context);
		if (drawableIcon != null)
		{
			try
			{
				icon.setBackground(drawableIcon);
			}
			catch (NoSuchMethodError e)
			{
				icon.setBackgroundDrawable(drawableIcon);
			}
		}
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Utils.dpToPx(sizeIcon, getResources()), Utils.dpToPx(sizeIcon, getResources()));
		params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		icon.setLayoutParams(params);
		addView(icon);
	}

	protected void setDefaultProperties()
	{
		minHeight = 36;
		minWidth = 88;
		rippleSize = 3;
		// Min size
		setMinimumHeight(Utils.dpToPx(minHeight, getResources()));
		setMinimumWidth(Utils.dpToPx(minWidth, getResources()));
		setBackgroundResource(R.drawable.background_transparent);
	}

	@Override
	protected void setAttributes(AttributeSet attrs)
	{
		// Icon of button
		int iconResource = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "iconFloat", -1);
		if (iconResource != -1)
			drawableIcon = getResources().getDrawable(iconResource);
		int bacgroundColor = attrs.getAttributeResourceValue(ANDROIDXML, "background", -1);
		if (bacgroundColor != -1)
		{
			setBackgroundColor(getResources().getColor(bacgroundColor));
		}
		else
		{
			// Color by hexadecimal
			String background = attrs.getAttributeValue(ANDROIDXML, "background");
			if (background != null)
				setBackgroundColor(Color.parseColor(background));
		}

		TypedArray styledAttrs = mContext.obtainStyledAttributes(attrs, R.styleable.CustomAttributes);

		sizeIcon = styledAttrs.getDimensionPixelSize(R.styleable.CustomAttributes_iconSize, 47);

		System.out.println("size of icon is: " + sizeIcon);
	}


	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		if (x != -1)
		{

			Paint paint = new Paint();
			paint.setAntiAlias(true);
			paint.setColor(makePressColor());
			canvas.drawCircle(x, y, radius, paint);
			if (radius > getHeight() / rippleSize)
				radius += rippleSpeed;
			if (radius >= getWidth())
			{
				x = -1;
				y = -1;
				radius = getHeight() / rippleSize;
				if (onClickListener != null)
					onClickListener.onClick(this);
			}
		}
		invalidate();
	}

	/**
	 * Make a dark color to ripple effect
	 *
	 * @return
	 */
	@Override
	protected int makePressColor()
	{
		return Color.parseColor("#88DDDDDD");
	}

	@Override
	public TextView getTextView()
	{
		return null;
	}

}
