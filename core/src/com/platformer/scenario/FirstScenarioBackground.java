package com.platformer.scenario;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platformer.spritesManager.BackgroundSpritesManager;
import com.platformer.utils.ScrollingBackground;

public class FirstScenarioBackground {

    private BackgroundSpritesManager backgroundSpritesManager;
    private Camera camera;
    private Texture background;
    private ScrollingBackground deeperCity;
    private ScrollingBackground deepestCity;
    private ScrollingBackground city;

    public FirstScenarioBackground(Camera camera) {
        this.backgroundSpritesManager = new BackgroundSpritesManager();
        this.camera = camera;
        this.initialize();
    }

    public void initialize() {
        this.background = this.backgroundSpritesManager.getLandscape();
        this.city = new ScrollingBackground(this.camera, this.backgroundSpritesManager.getCity(), 20, -100);
        this.deeperCity = new ScrollingBackground(this.camera, this.backgroundSpritesManager.getDeeperCity(), 26, 0);
        this.deepestCity = new ScrollingBackground(this.camera, this.backgroundSpritesManager.getDeepestCity(), 32, 100);
    }

    public void drawWith(SpriteBatch spriteBatch) {
        spriteBatch.draw(this.background, 0, -100);
        this.deepestCity.render(spriteBatch);
        this.deeperCity.render(spriteBatch);
        this.city.render(spriteBatch);
    }

}
