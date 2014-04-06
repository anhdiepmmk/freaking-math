package com.eobiet.app.freakingmath;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends Activity {

	private Context mContext = this;

	private TextView mTvNum;

	private TextView mTvTime;

	private ImageView mImgTick;

	private ImageView mImgDel;

	private TextView mTv1;

	private TextView mTv2;

	private int mNum = 0;

	static boolean exactly = false;

	public CountDown countDown;

	private boolean finish = false;

	private Handler failt = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			if (finish) {
				return;
			}

			PreferenceUtil.setValue(mContext, Var.KEY_SCORE, mNum);

			mNum = 0;

			SoundUtil.hexat(mContext, SoundUtil.DIA);

			EndDialog endDialog = new EndDialog(mContext, handler);
			endDialog.show();

			finish = true;

		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_play);

		mTvNum = (TextView) this.findViewById(R.id.tvNum);
		mTvTime = (TextView) this.findViewById(R.id.tvTime);
		mTv1 = (TextView) this.findViewById(R.id.tv1);
		mTv2 = (TextView) this.findViewById(R.id.tv2);

		mImgTick = (ImageView) this.findViewById(R.id.imgTick);
		mImgDel = (ImageView) this.findViewById(R.id.imgDel);
		mImgTick.setOnClickListener(onClickListener);
		mImgDel.setOnClickListener(onClickListener);

		countDown = new CountDown();
		countDown.setTvTime(mTvTime);
		countDown.setOnTickHtmlListener(failt);

		initFreakingMath();
	}

	@SuppressLint("NewApi")
	private void initFreakingMath() {
		mNum += 1;
		FreakingMath freakingMath = FreakingMath.randomFreakingMath();
		exactly = freakingMath.isExactly();

		mTvNum.setText(mNum + "");
		mTvTime.setText("2s");
		mTv1.setText(freakingMath.getLeft() + " " + freakingMath.getOpt() + " "
				+ freakingMath.getRight());
		mTv2.setText("= " + freakingMath.getResult());
		
//		mTv2.setRotation(90);

		countDown.tick();
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String object = (String) v.getTag();
			boolean b = Boolean.parseBoolean(object);

			if (exactly == b) {
				initFreakingMath();
				SoundUtil.hexat(mContext, SoundUtil.WINSOUND);
			} else {
				failt.sendEmptyMessage(0);
			}
		}
	};

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			finish();
		}
	};
	
	protected void onDestroy() {
		if(countDown.timer!=null){
			countDown.timer.cancel();
		}
		super.onDestroy();
		
	};

}
