package com.platformer.model.character.state;

import com.platformer.model.character.Character;

public class StandingState extends CharacterState {

    @Override
    public void grounded(Character character) {

    }

    @Override
    public void jump(Character character) {
        character.jump();
        character.setState(new JumpingState(character.currentHeight()));
    }

    @Override
    public void stopJump(Character character) {

    }

    @Override
    public void falling(Character character) {
        character.setState(new FallingState(character.currentHeight()));
    }

}
