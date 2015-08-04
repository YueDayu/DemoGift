package com.helloworld.demogift.select;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SlidingDrawer;

import com.helloworld.demogift.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YueXy on 7/30/2015.
 */
public class SelectActivity extends Activity
{
	private static final String TAG = "SelectActivity";

	private ImageView back;
	private SlidingDrawer slidingDrawer;

	private RecyclerView selectList1;
	private RecyclerView selectList2;
	private RecyclerView selectList3;

	private List<LessonsNode> nodeList1;
	private List<LessonsNode> nodeList2;


	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_layout);

		init();
	}

	private void init()
	{
		//
		findViews();

		selectList1.setLayoutManager(new FullyLinearLayoutManager(SelectActivity.this));
		selectList2.setLayoutManager(new FullyLinearLayoutManager(SelectActivity.this));
		selectList3.setLayoutManager(new FullyLinearLayoutManager(SelectActivity.this));

		nodeList1 = new ArrayList<>();
		nodeList2 = new ArrayList<>();

		back.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});

		initData();

		selectList1.setAdapter(new SelectListAdapter(SelectActivity.this, nodeList1));
		selectList2.setAdapter(new SelectListAdapter(SelectActivity.this, nodeList2));
		selectList3.setAdapter(new SelectListAdapter(SelectActivity.this, nodeList2));
	}

	private void findViews()
	{
		back = (ImageView) findViewById(R.id.select_back);

		selectList1 = (RecyclerView) findViewById(R.id.select_list_1);
		selectList2 = (RecyclerView) findViewById(R.id.select_list_2);
		selectList3 = (RecyclerView) findViewById(R.id.select_list_3);

		slidingDrawer = (SlidingDrawer) findViewById(R.id.myslidingDrawer);

		slidingDrawer.open();
	}

	private void initData()
	{
		nodeList1.add(new LessonsNode("新标准日本语N3", 0, 450));
		nodeList1.add(new LessonsNode("新标准日本语N2", 0, 550));
		nodeList1.add(new LessonsNode("新标准日本语N1", 0, 550));
		nodeList1.add(new LessonsNode("清华大学日语中级", 0, 750));
		nodeList1.add(new LessonsNode("清华大学日语高级", 0, 400));

		nodeList2.add(new LessonsNode("日式美食", 0, 400));
		nodeList2.add(new LessonsNode("最萌日语口语", 0, 480));
		nodeList2.add(new LessonsNode("艺术设计日语", 0, 480));
		nodeList2.add(new LessonsNode("建筑日语", 0, 480));
	}
}
