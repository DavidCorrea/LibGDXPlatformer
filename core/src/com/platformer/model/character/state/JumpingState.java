package com.platformer.model.character.state;

import com.platformer.model.character.Character;

public class JumpingState extends CharacterState {

    private float startingHeight;
    private float maximumHeight;

    public JumpingState(float startingHeight) {
        this.startingHeight = startingHeight;
        this.maximumHeight = 150;
    }

    @Override
    public void grounded(Character character) {
        character.stand();
    }

    @Override
    public void jump(Character character) {

    }

    @Override
    public void stopJump(Character character) {
        if(character.getY() - startingHeight > maximumHeight) {
            character.fall();
        }
    }

    @Override
    public void falling(Character character) {

    }

    @Override
    public void update(Character character) {
        character.applySpeed();
        character.applyAcceleration();

        if(character.getY() - startingHeight > maximumHeight) {
            stopJump(character);
        }
    }

}
