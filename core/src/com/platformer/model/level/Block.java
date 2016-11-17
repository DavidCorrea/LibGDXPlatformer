package com.platformer.model.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Block {

    private TextureRegion sprite;
    private Vector2 position;

    public Block(TextureRegion sprite, float x, float y){
        this.sprite = sprite;
        this.position = new Vector2(x, y);
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(this.sprite, this.position.x, this.position.y);
    }
}
