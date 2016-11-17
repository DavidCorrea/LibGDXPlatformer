package com.platformer.model.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.platformer.model.character.Character;
import com.platformer.spritesManager.BlockSpritesManager;

import java.util.ArrayList;
import java.util.List;

public class FloatingGround implements LevelComponent {

    private List<Block> blocks;

    private Vector2 position;
    private Vector2 topLeft;
    private Vector2 topRight;
    private BlockSpritesManager blockSpritesManager;

    public FloatingGround(Vector2 position) {
        this.blocks = new ArrayList<>();
        this.blockSpritesManager = new BlockSpritesManager();
        this.position = position;
        this.topLeft = new Vector2(this.position.x, this.position.y + 64);
        this.topRight = new Vector2(this.position.x + 128, this.position.y + 64);
        this.initialize();
    }

    public void render(final SpriteBatch spriteBatch) {
        this.blocks.forEach(block -> block.render(spriteBatch));
    }

    @Override
    public boolean collidesWith(Character character) {
        return character.bottomRightX()   >   this.topLeft.x  &&
               character.bottomLeftX()    <   this.topRight.x &&
               this.isOver(character.getY());
    }

    @Override
    public float getY() {
        return this.topRight.y;
    }

    private void initialize() {
        this.blocks.add(new Block(this.blockSpritesManager.getFloatingGroundLeftBorderBlock(), this.position.x, this.position.y));
        this.blocks.add(new Block(this.blockSpritesManager.getFloatingGroundBlock(), this.position.x + 64, this.position.y));
        this.blocks.add(new Block(this.blockSpritesManager.getFloatingGroundRightBorderBlock(), this.position.x + 128, this.position.y));
    }

    private boolean isOver(float possibleOverPoint) {
        /* I feel so guilty about this... Geez, I forgot to take my medicine... again. */
        return possibleOverPoint < this.topRight.y + 8 && possibleOverPoint > this.topRight.y - 8;
    }

}
