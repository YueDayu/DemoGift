package com.helloworld.demogift.demo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.helloworld.demogift.R;

/**
 * Created by YueXy on 7/30/2015.
 */
public class DemoActivity extends Activity
{
	private ImageView imageView1;
	private ImageView imageView2;

	private ImageView demoBack;

	private Drawable drawable1;
	private Drawable drawable2;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_layout);

		init();
	}

	private void init()
	{
		//
		imageView1 = (ImageView) findViewById(R.id.image1);
		imageView2 = (ImageView) findViewById(R.id.image2);

		drawable1 = getResources().getDrawable(R.mipmap.d1);
		drawable2 = getResources().getDrawable(R.mipmap.d2);

		DisplayMetrics dm = getResources().getDisplayMetrics();

		int height1 = (int) ((float) dm.widthPixels / drawable1.getMinimumWidth() * drawable1.getMinimumHeight());
		imageView1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, height1));

		int height2 = (int) ((float) dm.widthPixels / drawable2.getMinimumWidth() * drawable2.getMinimumHeight());
		imageView2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, height2));

		demoBack = (ImageView) findViewById(R.id.demo_back);
		demoBack.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
	}
}
