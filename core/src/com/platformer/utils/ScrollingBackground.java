package com.platformer.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrollingBackground {

    private Camera camera;
    private Texture sprite;
    private int depth;
    private int positionY;

    public ScrollingBackground(Camera camera, Texture sprite, int depth, int positionY) {
        this.camera = camera;
        this.sprite = sprite;
        this.depth = depth;
        this.positionY = positionY;
    }

    public Float offsetX() {
        return this.camera.position.x / (this.depth / 7);
    }

    public float offsetY() {
        return this.camera.position.y / (this.depth / 5);
    }

    public int repeats() {
        Double x = (Math.ceil(Gdx.graphics.getWidth() / this.sprite.getWidth()) + 2);
        int x1 = x.intValue();
        return Math.max(x1, 4);
    }

    public float totalWidth() {
        return this.repeats() * this.sprite.getWidth();
    }

    public float normalizedOffset() {
        return this.offsetX().intValue() % this.sprite.getWidth();
    }

    public void render(SpriteBatch spriteBatch) {
        for (int i = 0; i < this.repeats(); i++) {
            float currentOffset = this.normalizedOffset() + (i - 1) * this.sprite.getWidth();
            spriteBatch.draw(this.sprite, currentOffset, positionY + this.offsetY());
        }
    }

}
