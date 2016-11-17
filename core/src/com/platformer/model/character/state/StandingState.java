package com.platformer.model.character.state;

import com.platformer.model.character.Character;

public class StandingState extends CharacterState {

    @Override
    public void grounded(Character character) {

    }

    @Override
    public void jump(Character character) {
        character.increaseVerticalSpeedBy(600);
        character.setState(new JumpingState(character.getY()));
    }

    @Override
    public void stopJump(Character character) {

    }

    @Override
    public void falling(Character character) {
        character.increaseVerticalSpeedBy(-600);
        character.setState(new FallingState());
    }

    @Override
    public void update(Character character) {
        character.applySpeed();
        character.applyAcceleration();
    }

}
