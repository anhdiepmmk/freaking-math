package com.eobiet.app.freakingmath;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

 

public class SoundUtil {
	
 
	public static int WINSOUND = R.raw.winsound;
	public static int DIA = R.raw.mariodie;

	public static void hexat(Context context, int sound) {
		final MediaPlayer mediaPlayer = MediaPlayer.create(context, sound);
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaPlayer.release();
			}
		});
	}

}
