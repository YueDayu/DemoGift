package tools;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.helloworld.demogift.R;

/**
 * Created by YueXy on 7/31/2015.
 */
public class ToastTools
{
	public static void showToast(Activity context, String text)
	{
		showToast(context, text, 1000);
	}

	public static void showToast(Activity context, String text, int duration)
	{
		View layout = context.getLayoutInflater().inflate(R.layout.custom_toast, (ViewGroup) context.findViewById(R.id.custom_toast_layout));
		TextView textView = (TextView) layout.findViewById(R.id.toast_text);
		textView.setText(text);

		Toast toast = new Toast(context);
		toast.setDuration(duration);
		toast.setView(layout);
		toast.show();
	}
}
