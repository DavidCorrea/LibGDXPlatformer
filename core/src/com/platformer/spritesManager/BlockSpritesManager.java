package com.platformer.spritesManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BlockSpritesManager {

    private TextureRegion[][] blocks;

    public BlockSpritesManager() {
        Texture blocksTexture = new Texture("platformer-tileset.png");
        this.blocks = TextureRegion.split(blocksTexture, 63, 63);
    }

    public TextureRegion getGroundTopGreenBlock() {
        return this.getTexture(0, 0);
    }

    public TextureRegion getGroundTopGreenWithVineBlock() {
        return this.getTexture(0, 1);
    }

    public TextureRegion getGroundUnderWaterBlock() {
        return this.getTexture(1, 0);
    }

    public TextureRegion getGroundUnderWaterWithVineBlock() {
        return this.getTexture(1, 1);
    }

    public TextureRegion getFloatingGroundLeftBorderBlock() {
        return this.getTexture(3, 0);
    }

    public TextureRegion getFloatingGroundBlock() {
        return this.getTexture(3, 1);
    }

    public TextureRegion getFloatingGroundRightBorderBlock() {
        return this.getTexture(3, 3);
    }

    public TextureRegion getWaterBlock() {
        return this.getTexture(1, 3);
    }

    private TextureRegion getTexture(int row, int column) {
        return this.blocks[row][column];
    }

}
