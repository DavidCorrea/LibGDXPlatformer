package com.platformer.model.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.platformer.model.character.Character;
import com.platformer.spritesManager.BlockSpritesManager;

import java.util.ArrayList;
import java.util.List;

public class Ground implements LevelComponent {

    private Vector2 position;
    private Vector2 topLeft;
    private Vector2 topRight;
    private Integer maximumExtension;
    private List<Block> blocks;
    private BlockSpritesManager blockSpritesManager;

    public Ground(Vector2 position, int maximumExtension) {
        this.blocks = new ArrayList<>();
        this.blockSpritesManager = new BlockSpritesManager();
        this.position = position;
        this.maximumExtension = maximumExtension;
        this.topLeft = new Vector2(this.position.x, this.position.y);
        this.topRight = new Vector2(this.maximumExtension, this.position.y);
        this.initialize();
    }

    public void render(final SpriteBatch spriteBatch) {
        this.blocks.forEach(block -> block.render(spriteBatch));
    }

    @Override
    public boolean collidesWith(Character character) {
        return character.bottomRightX()   >  this.topLeft.x  &&
                character.bottomLeftX()   <  this.topRight.x &&
                this.isOver(character.getY());
    }

    @Override
    public float getY() {
        return this.position.y;
    }

    private void initialize() {
        for (float i = this.position.x; i <= this.maximumExtension; i += 64) {
            this.blocks.add(new Block(this.blockSpritesManager.getGroundTopGreenBlock(), i, -64));
            this.blocks.add(new Block(this.blockSpritesManager.getGroundUnderWaterBlock(), i, -128));
            this.blocks.add(new Block(this.blockSpritesManager.getWaterBlock(), i, -192));
        }
    }

    private boolean isOver(float possibleOverPoint) {
        /* I feel so guilty about this...  */
        return possibleOverPoint < this.topRight.y + 8 && possibleOverPoint > this.topRight.y - 8;
    }


}
