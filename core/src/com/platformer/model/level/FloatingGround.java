package com.platformer.model.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.platformer.spritesManager.BlockSpritesManager;

import java.util.ArrayList;
import java.util.List;

public class FloatingGround implements LevelComponent {

    private List<Block> blocks;

    private Vector2 position;
    private BlockSpritesManager blockSpritesManager;

    public FloatingGround(Vector2 position) {
        this.blocks = new ArrayList<>();
        this.blockSpritesManager = new BlockSpritesManager();
        this.position = position;
        this.initialize();
    }

    public void render(final SpriteBatch spriteBatch) {
        this.blocks.forEach(block -> block.render(spriteBatch));
    }

    private void initialize() {
        this.blocks.add(new Block(this.blockSpritesManager.getFloatingGroundLeftBorderBlock(), this.position.x, this.position.y));
        this.blocks.add(new Block(this.blockSpritesManager.getFloatingGroundBlock(), this.position.x + 64, this.position.y));
        this.blocks.add(new Block(this.blockSpritesManager.getFloatingGroundRightBorderBlock(), this.position.x + 128, this.position.y));
    }

}
