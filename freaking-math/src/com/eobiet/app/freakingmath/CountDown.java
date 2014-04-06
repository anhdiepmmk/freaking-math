package com.eobiet.app.freakingmath;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class CountDown {

	private Handler handler;

	private TextView tvTime;

	public CountDownTimer timer;

 

	public CountDown() {

	}

	public void setTvTime(TextView tv) {
		this.tvTime = tv;
	}

	public void setOnTickHtmlListener(Handler handler) {
		this.handler = handler;
	}

	public void tick() {
 

		if (timer != null) {
			timer.cancel();
		}

		timer = new CountDownTimer(4000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				long s = millisUntilFinished / 1000l;
				tvTime.setText(s+"s");
				 
			}

			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				Log.d("fi", "fi");
				handler.sendEmptyMessage(0);
			}
		};

		timer.start();

	}

}
