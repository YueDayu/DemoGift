package tools;

import android.media.MediaPlayer;

import com.helloworld.demogift.MyApplication;

/**
 * Created by YueXy on 8/4/2015.
 */
public class MediaPlayerTools
{
	public static void playMp3(int res)
	{
		MediaPlayer mp = MediaPlayer.create(MyApplication.getInstance(), res);
		mp.start();
	}
}
