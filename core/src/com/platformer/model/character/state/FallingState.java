package com.platformer.model.character.state;

import com.platformer.model.character.Character;

public class FallingState extends CharacterState {

    private float startingHeight;

    public FallingState(float startingHeight) {
        this.startingHeight = startingHeight;
    }

    @Override
    public void grounded(Character character) {
        character.setState(new StandingState());
    }

    @Override
    public void jump(Character character) {

    }

    @Override
    public void stopJump(Character character) {
        if(character.currentHeight() <= this.startingHeight) {
            character.setState(new StandingState());
            character.stand();
        }
    }

    @Override
    public void falling(Character character) {

    }

}
