package com.platformer.model.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.platformer.model.character.state.CharacterState;
import com.platformer.model.character.state.StandingState;
import com.platformer.spritesManager.CharacterSpriteManager;

public class Character {

    private Vector2 position;
    private Vector2 speed;
    private Vector2 acceleration;
    private CharacterSpriteManager animations;
    private TextureRegion currentFrame;
    private CharacterOrientation orientation;
    private float elapsedTime;

    private CharacterState state;
    private Animation currentAnimation;

    public Character() {
        this.position = new Vector2(700, 0);
        this.speed = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 0);
        this.animations = new CharacterSpriteManager();
        this.orientation = new CharacterOrientation();
        this.elapsedTime = 0;

        this.state = new StandingState();
        this.stand();
    }

    public void update() {
        this.applySpeed();
        this.applyAcceleration();
        this.updateState();
    }

    public void drawWith(SpriteBatch batch) {
        batch.draw(this.currentFrame, this.position.x, this.position.y, this.currentFrame.getRegionWidth(), this.currentFrame.getRegionHeight());
    }

    private void applySpeed() {
        float newPositionX = this.positionAfterSpeed(this.position.x, this.speed.x);
        float newPositionY = this.positionAfterSpeed(this.position.y, this.speed.y);

        /* This values could be defined in the current Level */
        if(newPositionX >= 0 && newPositionX <= 1800)
            this.position.set(newPositionX, newPositionY);
    }

    private void applyAcceleration() {
        this.speed.add(this.acceleration.x * Gdx.graphics.getDeltaTime(), this.acceleration.y * Gdx.graphics.getDeltaTime());
    }

    private float positionAfterSpeed(float position, float speed) {
        return position + speed * Gdx.graphics.getDeltaTime();
    }

    private void updateState() {
        this.speed.set(0, this.speed.y);
        this.currentAnimation = this.animations.getStandingAnimation();

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.speed.set(-500, this.speed.y);
            this.currentAnimation = this.animations.getRunningAnimation();
            this.orientation.faceLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.speed.set(500, this.speed.y);
            this.currentAnimation = this.animations.getRunningAnimation();
            this.orientation.faceRight();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            this.state.jump(this);
        }
        if(!Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            this.state.stopJump(this);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.currentAnimation = this.animations.getFiringAnimation();
        }

        this.updateCurrentFrame();
    }

    private void updateCurrentFrame() {
        this.elapsedTime += Gdx.graphics.getDeltaTime();
        this.currentFrame = this.orientation.frameWithOrientation(this.currentAnimation.getKeyFrame(elapsedTime));
    }

    public void stand() {
        this.speed.set(0, 0);
        this.position.set(this.position.x, 0);
        this.currentAnimation = this.animations.getStandingAnimation();
    }

    public void jump() {
        this.speed.set(0, 600);
        this.currentAnimation = this.animations.getJumpingAnimation();
    }

    public void fall() {
        this.speed.set(0, -600);
        this.currentAnimation = this.animations.getJumpingAnimation();
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public float currentHeight() {
        return this.position.y;
    }

    public float getX() {
        return this.position.x;
    }

    public float getY() {
        return this.position.y;
    }
}