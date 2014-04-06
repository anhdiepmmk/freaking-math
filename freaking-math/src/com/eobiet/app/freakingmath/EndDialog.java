package com.eobiet.app.freakingmath;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class EndDialog extends Dialog {

	private Context mContext;
	
	private RelativeLayout root;
	
	private TextView mTvYourMove, mTvYourBest;
	
 

	public EndDialog(Context context, final Handler handler) {
		super(context);
		// TODO Auto-generated constructor stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.end_dialog);
		getWindow().setBackgroundDrawableResource(R.drawable.bg_dialog);

		mContext = context;
		
		mTvYourMove = (TextView)this.findViewById(R.id.yourMove);
		mTvYourBest = (TextView)this.findViewById(R.id.yourBest);
		
		root = (RelativeLayout) findViewById(R.id.root);
		root.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EndDialog.this.dismiss();
			}
		});
		
		setOnDismissListener(new OnDismissListener() {
			
			@Override
			public void onDismiss(DialogInterface dialog) {
				// TODO Auto-generated method stub
				handler.sendEmptyMessage(0);
			}
		});
		
		int score = PreferenceUtil.getValue(mContext, Var.KEY_SCORE, 0);
		int bestScore = PreferenceUtil.getValue(mContext, Var.KEY_BEST_SCORE, 0);
		
		if(score > bestScore){
			 PreferenceUtil.setValue(mContext, Var.KEY_BEST_SCORE, score);
		}
		
		mTvYourMove.setText("YOUR MOVE: " +score);
		mTvYourBest.setText("BEST MOVE: "+bestScore);

	}
	

	


}
