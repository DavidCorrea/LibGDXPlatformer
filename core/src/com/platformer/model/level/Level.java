package com.platformer.model.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platformer.model.character.Character;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private List<LevelComponent> levelComponents;

    public Level() {
        this.levelComponents = new ArrayList<>();
    }

    public void addLevelComponent(LevelComponent levelComponent) {
        this.levelComponents.add(levelComponent);
    }

    public void render(final SpriteBatch spriteBatch) {
        this.levelComponents.forEach(levelComponent -> levelComponent.render(spriteBatch));
    }

    public boolean existsACollisionWith(Character character) {
        return this.levelComponents.stream().anyMatch(levelComponent -> levelComponent.collidesWith(character));
    }

    public LevelComponent floorThatCollisionsWith(Character character) {
        return this.levelComponents.stream().filter(levelComponent -> levelComponent.collidesWith(character)).findFirst().get();
    }
}
