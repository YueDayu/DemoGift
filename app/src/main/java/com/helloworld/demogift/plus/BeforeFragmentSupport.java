package com.helloworld.demogift.plus;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.helloworld.demogift.R;

import tools.ViewTools;

/**
 * Created by YueXy on 8/1/2015.
 */
public class BeforeFragmentSupport extends Fragment implements View.OnClickListener
{
	private View rootView;
	private ImageView imageView;
	private Drawable drawable;

	private Button btn1;
	private Button btn2;

	private PlusActivity plusActivity;

	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);

		plusActivity = (PlusActivity) activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		super.onCreateView(inflater, container, savedInstanceState);

		rootView = inflater.inflate(R.layout.plus_fragment_1, null);
		init();

		return rootView;
	}

	private void init()
	{
		imageView = (ImageView) rootView.findViewById(R.id.ftg_img_1_1);
		drawable = getResources().getDrawable(R.mipmap.a1);

		DisplayMetrics dm = getResources().getDisplayMetrics();

		int length = ViewTools.dp2px(getActivity(), 40);

		int height = (int) (((float) dm.widthPixels - length) / drawable.getMinimumWidth() * drawable.getMinimumHeight());
		imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height));

		btn1 = (Button) rootView.findViewById(R.id.plus_bnt1);
		btn2 = (Button) rootView.findViewById(R.id.plus_bnt2);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		plusActivity.switchFragment();
	}
}
