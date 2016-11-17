package com.platformer.model.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private List<Block> blocks;

    public Level() {
        this.blocks = new ArrayList<>();
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
    }

    public void render(final SpriteBatch spriteBatch) {
        this.blocks.forEach(block -> block.render(spriteBatch));
    }

}
