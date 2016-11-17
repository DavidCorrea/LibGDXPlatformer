package com.platformer.scenario;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platformer.model.level.Block;
import com.platformer.model.level.Level;
import com.platformer.spritesManager.BlockSpritesManager;

public class FirstScenario {

    private Level level;
    private BlockSpritesManager blockSpritesManager;

    public FirstScenario() {
        this.level = new Level();
        this.blockSpritesManager = new BlockSpritesManager();
        this.initialize();
    }

    public void drawWith(SpriteBatch spriteBatch) {
        this.level.render(spriteBatch);
    }

    private void initialize() {
        int startingX = 0;
        int maximumX = 1856;

        for (int i = startingX; i <= maximumX; i += 64) {
            this.level.addBlock(new Block(this.blockSpritesManager.getGroundTopGreenBlock(), i, -64));
            this.level.addBlock(new Block(this.blockSpritesManager.getGroundUnderWaterBlock(), i, -128));
            this.level.addBlock(new Block(this.blockSpritesManager.getWaterBlock(), i, -192));
        }

        this.addPlatform(20, 50);
        this.addPlatform(500, 50);
        this.addPlatform(1250, 50);

        this.addPlatform(200, 100);
        this.addPlatform(750, 100);
        this.addPlatform(1000, 100);
    }

    private void addPlatform(float x, float y) {
        this.level.addBlock(new Block(this.blockSpritesManager.getFloatingGroundLeftBorderBlock(), x, y));
        this.level.addBlock(new Block(this.blockSpritesManager.getFloatingGroundBlock(), x + 64, y));
        this.level.addBlock(new Block(this.blockSpritesManager.getFloatingGroundRightBorderBlock(), x + 128, y));
    }
}
