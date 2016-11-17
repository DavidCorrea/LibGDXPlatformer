package com.platformer.spritesManager;

import com.badlogic.gdx.graphics.Texture;

public class BackgroundSpritesManager {

    private Texture landscape;
    private Texture city;
    private Texture deeperCity;
    private Texture deepestCity;

    public BackgroundSpritesManager() {
        this.landscape = new Texture("landscape.jpg");
        this.city = new Texture("city.png");
        this.deeperCity = new Texture("city-deeper.png");
        this.deepestCity = new Texture("city-deepest.png");
    }

    public Texture getDeepestCity() {
        return this.deepestCity;
    }

    public Texture getDeeperCity() {
        return this.deeperCity;
    }

    public Texture getCity() {
        return this.city;
    }

    public Texture getLandscape() {
        return this.landscape;
    }
}
