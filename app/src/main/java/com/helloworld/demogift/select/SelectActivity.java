package com.helloworld.demogift.select;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

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

	private RecyclerView selectList1;
	private RecyclerView selectList2;
	private RecyclerView selectList3;

	private List<LessonsNode> nodeList1;

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

		back.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});

		for (int i = 0; i < 10; i++)
		{
			nodeList1.add(new LessonsNode("lesson" + i, "num", false));
		}

		selectList1.setAdapter(new SelectListAdapter(SelectActivity.this, nodeList1));
		selectList2.setAdapter(new SelectListAdapter(SelectActivity.this, nodeList1));
		selectList3.setAdapter(new SelectListAdapter(SelectActivity.this, nodeList1));
	}

	private void findViews()
	{
		back = (ImageView) findViewById(R.id.select_back);

		selectList1 = (RecyclerView) findViewById(R.id.select_list_1);
		selectList2 = (RecyclerView) findViewById(R.id.select_list_2);
		selectList3 = (RecyclerView) findViewById(R.id.select_list_3);
	}
}
