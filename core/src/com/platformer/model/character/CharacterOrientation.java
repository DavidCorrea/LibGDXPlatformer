package com.platformer.model.character;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CharacterOrientation {

    private boolean facingLeft;
    private boolean facingRight;

    public void CharacterOrientation() {
        this.facingRight = true;
        this.facingLeft = false;
    }

    public void faceLeft() {
        this.facingRight = false;
        this.facingLeft = true;
    }

    public void faceRight() {
        this.facingRight = true;
        this.facingLeft = false;
    }

    public boolean isFacingLeft() {
        return facingLeft;
    }
}
