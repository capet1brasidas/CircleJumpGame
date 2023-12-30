package com.jga.jumper;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.jga.jumper.CircleJumpGame;
import com.jga.jumper.ads.AdController;
import com.jga.jumper.ads.AdUnitIds;
import com.jga.jumper.ads.AdUtils;

import java.net.NetworkInterface;


public class AndroidLauncher extends AndroidApplication implements AdController {

	private AdView bannerAdView;
	private InterstitialAd interstitialAd;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initAds();
		initUi();



	}

	private void initUi() {
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		View gameView=initializeForView(new CircleJumpGame(this), config);


		RelativeLayout layout=new RelativeLayout(this);

		//ad view params
		RelativeLayout.LayoutParams adParams=new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT
		);

		adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

		//game view params
		RelativeLayout.LayoutParams gameParams=new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT

		);
		gameParams.addRule(RelativeLayout.ABOVE);

		layout.addView(bannerAdView,adParams);
		layout.addView(gameView,gameParams);

		setContentView(layout);


	}

	@Override
	protected void onResume() {
		super.onResume();
		bannerAdView.resume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		bannerAdView.pause();
	}

	@Override
	protected void onDestroy() {
		bannerAdView.destroy();
		super.onDestroy();
	}




	private void initAds() {


		bannerAdView=new AdView(this);
		bannerAdView.setId(R.id.adViewId);
		bannerAdView.setAdUnitId(AdUnitIds.BANNER_ID);
		bannerAdView.setAdSize(AdSize.BANNER);


	}

	@Override
	public void showBanner() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				loadBanner();
			}
		});

	}

	private void loadBanner(){
		if(isNetWorkConnected()){
			bannerAdView.loadAd(AdUtils.buildRequest());

		}
	}

	@Override
	public void showInterstitial() {

	}

	@Override
	public boolean isNetWorkConnected() {
		ConnectivityManager connectivityManager=
				(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();


		return networkInfo!=null&&networkInfo.isConnectedOrConnecting();
	}
}
