package com.platformer.model.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platformer.model.character.Character;

public interface LevelComponent {

    public void render(final SpriteBatch spriteBatch);

    boolean collidesWith(Character character);

    float getY();
}
