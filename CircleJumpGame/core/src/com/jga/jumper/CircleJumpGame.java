package com.jga.jumper;


import com.jga.jumper.ads.AdController;
import com.jga.jumper.screen.game.GameScreen;
import com.jga.jumper.screen.loading.LoadingScreen;
import com.jga.jumper.util.game.GameBase;

public class CircleJumpGame extends GameBase {

	public CircleJumpGame(AdController adController){
		super(adController);
	}

	@Override
	public void postCreate() {
		getAdController().showBanner();
		setScreen(new LoadingScreen(this));
	}
}
