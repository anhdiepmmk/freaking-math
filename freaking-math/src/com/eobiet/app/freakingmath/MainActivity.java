package com.eobiet.app.freakingmath;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd; 

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private Button mBtnRate;

	private ImageView mImgTop;

	private ImageView mImgPlay;

	private Context mContext = this;

	private InterstitialAd interstitial;

	private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		this.mBtnRate = (Button) this.findViewById(R.id.btnRate);
		this.mImgTop = (ImageView) this.findViewById(R.id.imgTop);
		this.mImgPlay = (ImageView) this.findViewById(R.id.imgPlay);

		this.mBtnRate.setOnClickListener(this);
		this.mImgTop.setOnClickListener(this);
		this.mImgPlay.setOnClickListener(this);

		// Create the interstitial.
		interstitial = new InterstitialAd(this, Var.MY_AD_UNIT_ID);
		interstitial.loadAd(new AdRequest());

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		adView = (AdView) this.findViewById(R.id.adView);
		adView.loadAd(new AdRequest());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();

		switch (id) {
		case R.id.btnRate:
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("market://details?id=" + getPackageName())));
			break;
		case R.id.imgTop:

			break;
		case R.id.imgPlay:
			startActivity(new Intent(mContext, PlayActivity.class));
			break;

		}
	}

	@SuppressLint("NewApi")
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (interstitial.isReady()) {
			interstitial.show();
		}
		super.onBackPressed();
	}

}
