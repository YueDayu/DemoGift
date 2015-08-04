package com.helloworld.demogift.plus;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.helloworld.demogift.R;

import tools.MediaPlayerTools;
import tools.SharedPreferencesTools;
import tools.ToastTools;
import tools.ViewTools;

/**
 * Created by YueXy on 8/1/2015.
 */
public class AfterFragmenSupport extends Fragment
{
	private View rootView;

	private ImageView imageView2;
	private ImageView ftg_word_2;
	private ImageView like;
	private ImageView sounds;

	private Drawable drawable2;

	private PlusActivity plusActivity;

	private Button next;

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

		rootView = inflater.inflate(R.layout.plus_fragment_2, null);
		init();

		return rootView;
	}

	private void init()
	{
		imageView2 = (ImageView) rootView.findViewById(R.id.ftg_img_2_2);
		ftg_word_2 = (ImageView) rootView.findViewById(R.id.ftg_word_2);
		next = (Button) rootView.findViewById(R.id.ftg_btn_2);
		like = (ImageView) rootView.findViewById(R.id.ftg_like_2);
		sounds = (ImageView) rootView.findViewById(R.id.ftg_sound_2);

		setImage();

		like.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				ToastTools.showToast(getActivity(), "收藏成功");
			}
		});

		sounds.setOnClickListener(new View.OnClickListener()
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

		next.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (plusActivity.local == 0)
				{
					plusActivity.local++;
					plusActivity.switchFragment();
				}
				else
				{
					new FinishDialog(getActivity()).show();
					SharedPreferencesTools.getInstance().setMainEyes(true);
				}
			}
		});
	}

	public void setImage()
	{
		if (plusActivity.local == 0)
		{
			drawable2 = getResources().getDrawable(R.mipmap.word_detai_1);
			imageView2.setImageResource(R.mipmap.word_detai_1);
			ftg_word_2.setImageResource(R.mipmap.word_pic1);
		}
		else
		{
			drawable2 = getResources().getDrawable(R.mipmap.word_detai_2);
			ftg_word_2.setImageResource(R.mipmap.word_pic2);
			imageView2.setImageResource(R.mipmap.word_detai_2);
			next.setText("完成今日任务");
		}

//		DisplayMetrics dm = getResources().getDisplayMetrics();
//		int length = ViewTools.dp2px(getActivity(), 40);
//		int height2 = (int) (((float) dm.widthPixels - length) / drawable2.getMinimumWidth() * drawable2.getMinimumHeight());
//		imageView2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, height2));
	}
}
