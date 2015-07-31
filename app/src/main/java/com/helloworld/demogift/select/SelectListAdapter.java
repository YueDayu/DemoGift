package com.helloworld.demogift.select;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.helloworld.demogift.R;

import java.util.List;

/**
 * Created by YueXy on 7/31/2015.
 */
public class SelectListAdapter extends RecyclerView.Adapter<SelectListAdapter.SelectViewHolder>
{
	private static final String TAG = "SelectListAdapter";

	private final Context mContext;
	private final LayoutInflater layoutInflater;

	private List<LessonsNode> list;

	public SelectListAdapter(Context context, List<LessonsNode> l)
	{
		this.mContext = context;
		this.list = l;

		this.layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public SelectViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		return new SelectViewHolder(layoutInflater.inflate(R.layout.select_list_item, parent, false));
	}

	@Override
	public void onBindViewHolder(final SelectViewHolder holder, int position)
	{
		holder.lessonName.setText(list.get(position).lessonName);
		holder.number.setText(list.get(position).lessonNum);

		if (list.get(position).isSelected)
			holder.selectedImg.setVisibility(View.VISIBLE);
		else
			holder.selectedImg.setVisibility(View.GONE);

		holder.itemLayout.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (holder.selectedImg.getVisibility() == View.GONE)
				{
					holder.selectedImg.setVisibility(View.VISIBLE);

					// show dialog
					SelectPopupWindow selectPopupWindow = new SelectPopupWindow((Activity)mContext, null);
					selectPopupWindow.showAtLocation(LayoutInflater.from(mContext).inflate(R.layout.select_layout, null),
							Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
				}
			}
		});
	}

	@Override
	public int getItemCount()
	{
		return list.size();
	}

	public static class SelectViewHolder extends RecyclerView.ViewHolder
	{
		public TextView lessonName;
		public TextView number;
		public ImageView selectedImg;

		public RelativeLayout itemLayout;

		public SelectViewHolder(View itemView)
		{
			super(itemView);

			lessonName = (TextView) itemView.findViewById(R.id.lesson_name);
			number = (TextView) itemView.findViewById(R.id.lesson_number);
			selectedImg = (ImageView) itemView.findViewById(R.id.lesson_selected);
			itemLayout = (RelativeLayout) itemView.findViewById(R.id.item_layout);

			selectedImg.setVisibility(View.GONE);
		}
	}
}
