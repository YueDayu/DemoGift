package tools;

import android.content.Context;

/**
 * Created by YueXy on 8/1/2015.
 */
public class ViewTools
{
	public static int dp2px(Context context, int dp)
	{
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}
}
