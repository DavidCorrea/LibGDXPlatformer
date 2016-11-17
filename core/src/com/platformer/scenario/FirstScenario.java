package com.platformer.scenario;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.platformer.model.character.Character;
import com.platformer.model.level.FloatingGround;
import com.platformer.model.level.Ground;
import com.platformer.model.level.Level;
import com.platformer.model.level.LevelComponent;

public class FirstScenario {

    private Level level;

    public FirstScenario() {
        this.level = new Level();
        this.initialize();
    }

    public void drawWith(SpriteBatch spriteBatch) {
        this.level.render(spriteBatch);
    }

    public boolean existsACollisionWith(Character character) {
        return this.level.existsACollisionWith(character);
    }

    public LevelComponent floorThatCollisionsWith(Character character) {
        return this.level.floorThatCollisionsWith(character);
    }

    public void addFloatingGround(float x, float y) {
        this.level.addLevelComponent(new FloatingGround(new Vector2(x, y)));
    }

    private void initialize() {
        this.level.addLevelComponent(new Ground(new Vector2(0, 0), 1856));

        this.level.addLevelComponent(new FloatingGround(new Vector2(20, 50)));
        this.level.addLevelComponent(new FloatingGround(new Vector2(500, 50)));
        this.level.addLevelComponent(new FloatingGround(new Vector2(1250, 50)));

        this.level.addLevelComponent(new FloatingGround(new Vector2(200, 100)));
        this.level.addLevelComponent(new FloatingGround(new Vector2(1000, 100)));

        this.level.addLevelComponent(new FloatingGround(new Vector2(750, 150)));
        this.level.addLevelComponent(new FloatingGround(new Vector2(1000, 200)));

        this.level.addLevelComponent(new FloatingGround(new Vector2(600, 250)));

        this.level.addLevelComponent(new FloatingGround(new Vector2(1000, 300)));
    }
}
