package com.helloworld.demogift.laction;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.helloworld.demogift.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tools.MediaPlayerTools;

/**
 * Created by YueXy on 8/10/2015.
 */
public class LocationDialog extends Dialog
{
	private Context mContext;

	private RecyclerView recyclerView;
	private LinearLayoutManager mLinearLayoutManager;

	private List<LocationListNode> list;

	public LocationDialog(Context context)
	{
		this(context, R.style.theme_dialog);
	}

	public LocationDialog(Context context, int theme)
	{
		super(context, theme);
		mContext = context;
	}

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location_dialog_layout);

		init();
	}

	private void init()
	{
		findViews();

		initData();

		mLinearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
		recyclerView.setLayoutManager(mLinearLayoutManager);
		recyclerView.setHasFixedSize(true);

		recyclerView.setAdapter(new LocationDialogListAdapter(mContext, list));
	}

	private void findViews()
	{
		recyclerView = (RecyclerView) findViewById(R.id.location_dialog_list);
	}

	private void initData()
	{
		list = new ArrayList<>();

		list.add(new LocationListNode("宿舍", "寮"));
		list.add(new LocationListNode("书架", "本棚"));
		list.add(new LocationListNode("起床", "起きて"));
		list.add(new LocationListNode("楼长", "階の長"));
		list.add(new LocationListNode("学生公寓", "学生のマンション"));
		list.add(new LocationListNode("上课", "授業"));
		list.add(new LocationListNode("学习", "勉強する"));
	}
}
