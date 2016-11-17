package com.platformer.model.character.state;

import com.platformer.model.character.Character;
import com.platformer.spritesManager.CharacterSpriteManager;

public class StandingState extends CharacterState {

    private CharacterSpriteManager characterSpriteManager;

    public StandingState() {
        this.characterSpriteManager = new CharacterSpriteManager();
    }

    @Override
    public void grounded(Character character) {

    }

    @Override
    public void jump(Character character) {
        character.jump();
    }

    @Override
    public void stopJump(Character character) {

    }

    @Override
    public void falling(Character character) {
        character.fall();
    }

    @Override
    public void update(Character character) {
        character.applySpeed();
        character.applyAcceleration();
    }

}
