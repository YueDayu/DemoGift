package com.helloworld.demogift.plus;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.helloworld.demogift.R;

import tools.MediaPlayerTools;

/**
 * Created by YueXy on 8/1/2015.
 */
public class FinishDialog extends Dialog
{
	private Context mContext;

	public FinishDialog(Context context)
	{
		this(context, R.style.theme_dialog);
	}

	public FinishDialog(Context context, int theme)
	{
		super(context, theme);
	}


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finish_dialog_layout);
		MediaPlayerTools.playMp3(R.raw.music);
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		MediaPlayerTools.stop();
	}

}
