package com.helloworld.demogift.plus;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.helloworld.demogift.R;

import tools.ViewTools;

/**
 * Created by YueXy on 8/1/2015.
 */
public class AfterFragmenSupport extends Fragment
{
	private View rootView;
	private ImageView imageView1;
	private ImageView imageView2;

	private Drawable drawable1;
	private Drawable drawable2;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		super.onCreateView(inflater, container, savedInstanceState);

		rootView = inflater.inflate(R.layout.plus_fragment_2, null);
		init();

		return rootView;
	}

	private void init()
	{
		imageView1 = (ImageView) rootView.findViewById(R.id.ftg_img_2_1);
		imageView2 = (ImageView) rootView.findViewById(R.id.ftg_img_2_2);

		drawable1 = getResources().getDrawable(R.mipmap.b1);
		drawable2 = getResources().getDrawable(R.mipmap.b2);

		DisplayMetrics dm = getResources().getDisplayMetrics();

		int length = ViewTools.dp2px(getActivity(), 40);

		int height1 = (int) (((float) dm.widthPixels - length) / drawable1.getMinimumWidth() * drawable1.getMinimumHeight());
		imageView1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, height1));

		int height2 = (int) (((float) dm.widthPixels - length) / drawable2.getMinimumWidth() * drawable2.getMinimumHeight());
		imageView2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, height2));

		new FinishDialog(getActivity()).show();
	}
}
