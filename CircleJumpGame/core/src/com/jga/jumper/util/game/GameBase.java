package com.jga.jumper.util.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.jga.jumper.ads.AdController;

public abstract class GameBase extends Game {
    private final AdController adController;

    private AssetManager assetManager;
    private SpriteBatch batch;

    public GameBase(AdController adController) {
        this.adController=adController;
    }

    public AdController getAdController() {
        return adController;
    }

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        assetManager=new AssetManager();
        assetManager.getLogger().setLevel(Logger.DEBUG);

        batch=new SpriteBatch();
        postCreate();
    }

    public abstract void postCreate();

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    @Override
    public void dispose() {
        super.dispose();
        assetManager.dispose();
        batch.dispose();

    }

}
