package com.jga.jumper;

import com.badlogic.gdx.utils.Logger;
import com.jga.jumper.ads.AdController;

public class DesktopAdController implements AdController {
    //constants
    private static final Logger log=new Logger(DesktopAdController.class.getName(),Logger.DEBUG);
    //public methods
    @Override
    public void showBanner() {
        log.debug("show banner");
    }

    @Override
    public void showInterstitial() {
        log.debug("show interstitial");
    }

    @Override
    public boolean isNetWorkConnected() {
        return false;
    }
}
