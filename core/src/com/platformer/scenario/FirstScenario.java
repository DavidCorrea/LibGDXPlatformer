package com.platformer.scenario;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.platformer.model.level.FloatingGround;
import com.platformer.model.level.Ground;
import com.platformer.model.level.Level;

public class FirstScenario {

    private Level level;

    public FirstScenario() {
        this.level = new Level();
        this.initialize();
    }

    public void drawWith(SpriteBatch spriteBatch) {
        this.level.render(spriteBatch);
    }

    private void initialize() {
        this.level.addLevelComponent(new Ground(new Vector2(0, 0), 1856));

        this.level.addLevelComponent(new FloatingGround(new Vector2(20, 50)));
        this.level.addLevelComponent(new FloatingGround(new Vector2(500, 50)));
        this.level.addLevelComponent(new FloatingGround(new Vector2(1250, 50)));
        this.level.addLevelComponent(new FloatingGround(new Vector2(200, 100)));
        this.level.addLevelComponent(new FloatingGround(new Vector2(750, 100)));
        this.level.addLevelComponent(new FloatingGround(new Vector2(1000, 100)));
    }
}
