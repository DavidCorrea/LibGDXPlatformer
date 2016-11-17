package com.platformer.spritesManager;

import com.badlogic.gdx.graphics.Texture;

public class HUDManager {

    private Texture healthBar;

    public HUDManager() {
        this.healthBar = new Texture("healthbar.png");
    }

    public Texture getHealthBar() {
        return healthBar;
    }
}
