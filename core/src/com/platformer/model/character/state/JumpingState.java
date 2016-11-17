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

    }

    @Override
    public void jump(Character character) {

    }

    @Override
    public void stopJump(Character character) {
        if(character.currentHeight() >= maximumHeight && character.currentHeight() > startingHeight) {
            character.setState(new FallingState(this.startingHeight));
            character.fall();
        }

    }

    @Override
    public void falling(Character character) {

    }

}
