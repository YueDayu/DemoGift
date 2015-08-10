package com.helloworld.demogift.laction;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.helloworld.demogift.R;

import java.util.List;
import java.util.Map;

import tools.MediaPlayerTools;
import tools.ToastTools;

/**
 * Created by YueXy on 8/10/2015.
 */
public class LocationDialogListAdapter extends RecyclerView.Adapter<LocationDialogListAdapter.LocationDialogListViewHolder>
{
	private Context mContext;
	private List<LocationListNode> mList;

	private LayoutInflater layoutInflater;

	public LocationDialogListAdapter(Context context, List<LocationListNode> list)
	{
		this.mContext = context;
		this.mList = list;

		layoutInflater = LayoutInflater.from(mContext);
	}

	@Override
	public LocationDialogListViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		return new LocationDialogListViewHolder(layoutInflater.inflate(R.layout.location_dialog_list_item, null, false));
	}

	@Override
	public void onBindViewHolder(LocationDialogListViewHolder holder, int position)
	{
		holder.chinese.setText(mList.get(position).chinese);
		holder.japanese.setText(mList.get(position).japanese);
	}

	@Override
	public int getItemCount()
	{
		return mList.size();
	}

	public class LocationDialogListViewHolder extends RecyclerView.ViewHolder
	{
		private TextView chinese;
		private TextView japanese;
		private ImageView like;
		private ImageView sounds;

		public LocationDialogListViewHolder(View itemView)
		{
			super(itemView);

			chinese = (TextView) itemView.findViewById(R.id.location_dialog_list_chn);
			japanese = (TextView) itemView.findViewById(R.id.location_dialog_list_jpn);
			like = (ImageView) itemView.findViewById(R.id.location_dialog_list_like);
			sounds = (ImageView) itemView.findViewById(R.id.location_dialog_list_sound);

			like.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					ToastTools.showToast((Activity)mContext, "收藏成功");
				}
			});

			sounds.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					MediaPlayerTools.playMp3(R.raw.sounds);
				}
			});
		}
	}
}
