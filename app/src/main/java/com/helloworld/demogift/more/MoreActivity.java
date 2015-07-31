package com.helloworld.demogift.more;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.helloworld.demogift.R;

/**
 * Created by YueXy on 7/30/2015.
 */
public class MoreActivity extends Activity
{
	private ImageView imageView1;
	private ImageView imageView2;
	private ImageView imageView3;
	private ImageView moreBack;

	private Drawable drawable1;
	private Drawable drawable2;
	private Drawable drawable3;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_layout);

		init();
	}

	private void init()
	{
		//
		imageView1 = (ImageView) findViewById(R.id.more_image1);
		imageView2 = (ImageView) findViewById(R.id.more_image2);
		imageView3 = (ImageView) findViewById(R.id.more_image3);

		drawable1 = getResources().getDrawable(R.mipmap.c1);
		drawable2 = getResources().getDrawable(R.mipmap.c2);
		drawable3 = getResources().getDrawable(R.mipmap.c3);

		DisplayMetrics dm = getResources().getDisplayMetrics();

		int height1 = (int) ((float) dm.widthPixels / drawable1.getMinimumWidth() * drawable1.getMinimumHeight());
		int height2 = (int) ((float) dm.widthPixels / drawable2.getMinimumWidth() * drawable2.getMinimumHeight());
		int height3 = (int) ((float) dm.widthPixels / drawable3.getMinimumWidth() * drawable3.getMinimumHeight());

		imageView1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, height1));
		imageView2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, height2));
		imageView3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, height3));

		moreBack = (ImageView) findViewById(R.id.more_back);
		moreBack.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
	}
}
