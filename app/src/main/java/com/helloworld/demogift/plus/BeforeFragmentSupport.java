package com.helloworld.demogift.plus;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.helloworld.demogift.R;

import tools.MediaPlayerTools;
import tools.ToastTools;
import tools.ViewTools;

/**
 * Created by YueXy on 8/1/2015.
 */
public class BeforeFragmentSupport extends Fragment implements View.OnClickListener
{
	private View rootView;

	private Button btn1;
	private Button btn2;

	private PlusActivity plusActivity;

	private ImageView word;
	private ImageView word_han;
	private ImageView like;
	private ImageView sound;

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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		super.onCreateView(inflater, container, savedInstanceState);

		rootView = inflater.inflate(R.layout.plus_fragment_1, null);
		init();

		return rootView;
	}

	private void init()
	{

		//plusActivity.local = 1;
		System.out.println("call init");

		btn1 = (Button) rootView.findViewById(R.id.plus_bnt1);
		btn2 = (Button) rootView.findViewById(R.id.plus_bnt2);

		word = (ImageView) rootView.findViewById(R.id.ftg_word_1);
		word_han = (ImageView) rootView.findViewById(R.id.ftg_han);
		like = (ImageView) rootView.findViewById(R.id.ftg_like_1);
		sound = (ImageView) rootView.findViewById(R.id.ftg_sound_1);

		word.setImageResource(R.mipmap.word1);
		word_han.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (plusActivity.local == 0)
					word_han.setImageResource(R.mipmap.word_button_h1);
				else
					word_han.setImageResource(R.mipmap.word_button_h2);
			}
		});
		sound.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (plusActivity.local == 0)
					MediaPlayerTools.playMp3(R.raw.sounds);
				else
					MediaPlayerTools.playMp3(R.raw.sounds);
			}
		});

		like.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				ToastTools.showToast(getActivity(), "收藏成功");
			}
		});

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		plusActivity.switchFragment();
	}

	public void setImage()
	{
		word_han.setImageResource(R.mipmap.word_button);

		if (plusActivity.local == 0)
			word.setImageResource(R.mipmap.word1);
		else
			word.setImageResource(R.mipmap.word2);
	}
}
