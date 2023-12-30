package com.jga.jumper;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.jga.jumper.ads.AdController;
import com.jga.jumper.config.GameConfig;


// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {

	private static final AdController AD_CONTROLLER=new DesktopAdController();
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode((int) GameConfig.WIDTH,(int)GameConfig.HEIGHT);

		config.setTitle("circle-jumper");
		new Lwjgl3Application(new CircleJumpGame(AD_CONTROLLER),config);
//		new Lwjgl3Application(new CircleJumpGame(), config);
	}
}
