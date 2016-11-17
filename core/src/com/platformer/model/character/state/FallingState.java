package com.platformer.model.character.state;

import com.platformer.model.character.Character;

public class FallingState extends CharacterState {

    @Override
    public void grounded(Character character) {
        character.setState(new StandingState());
    }

    @Override
    public void jump(Character character) {

    }

    @Override
    public void stopJump(Character character) {

    }

    @Override
    public void falling(Character character) {

    }

    @Override
    public void update(Character character) {
        character.applySpeed();
        character.applyAcceleration();
    }

}
