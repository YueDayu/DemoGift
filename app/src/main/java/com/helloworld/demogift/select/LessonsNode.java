package com.helloworld.demogift.select;

/**
 * Created by YueXy on 7/31/2015.
 */
public class LessonsNode
{
	public String lessonName;
	public String lessonNum;
	public boolean isSelected;

	public int lessonLength;
	public int lessonRate;

	public LessonsNode(String lna, String lnu, boolean b)
	{
		lessonName = lna;
		lessonNum = lnu;
		isSelected = b;
	}

	public LessonsNode(String name, int rate, int length)
	{
		lessonName = name;
		lessonRate = rate;
		lessonLength = length;
	}
}
