package tools;

import android.media.MediaPlayer;

import com.helloworld.demogift.MyApplication;

/**
 * Created by YueXy on 8/4/2015.
 */
public class MediaPlayerTools
{
	private static MediaPlayer mp = null;

	public static void playMp3(int res)
	{
		mp = MediaPlayer.create(MyApplication.getInstance(), res);
		mp.start();
	}

	public static void stop()
	{
		mp.stop();
		mp.release();
	}
}
