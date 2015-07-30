package tools;

import android.graphics.Typeface;

import com.helloworld.demogift.MyApplication;

/**
 * Created by YueXy on 7/30/2015.
 */
public class TypefaceTools
{
	private static Typeface boldTypeface = null;
	private static Typeface typeface = null;

	public static Typeface getBoldTypeface()
	{
		if (boldTypeface == null)
			boldTypeface = Typeface.createFromAsset(MyApplication.getInstance().getAssets(), "fonts/demo.ttf");

		return boldTypeface;
	}
}
