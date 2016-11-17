package com.platformer.model.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.platformer.model.character.state.CharacterState;
import com.platformer.model.character.state.FallingState;
import com.platformer.model.character.state.JumpingState;
import com.platformer.model.character.state.StandingState;
import com.platformer.model.level.LevelComponent;
import com.platformer.scenario.FirstScenario;
import com.platformer.spritesManager.CharacterSpriteManager;

public class Character {

    private FirstScenario scenario;

    private Vector2 position;
    private Vector2 speed;
    private Vector2 acceleration;
    private CharacterSpriteManager animations;
    private TextureRegion currentFrame;
    private CharacterOrientation orientation;
    private float elapsedTime;

    private CharacterState state;
    private Animation currentAnimation;

    private boolean justJumped;
    private Sound jumpSound;

    public Character(FirstScenario scenario) {
        this.position = new Vector2(700, 0);
        this.speed = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 0);
        this.animations = new CharacterSpriteManager();
        this.orientation = new CharacterOrientation();
        this.elapsedTime = 0;

        this.orientation.faceRight();
        this.fall();
        this.updateCurrentFrame();

        this.scenario = scenario;
        this.justJumped = false;
        this.jumpSound = Gdx.audio.newSound(Gdx.files.internal("Jump sound.wav"));
    }

    public void update() {
        this.checkCollisionsWithFloors();
        this.checkKeys();
        this.state.update(this);
        this.updateCurrentFrame();
    }

    public void drawWith(SpriteBatch batch) {
        float x = this.orientation.isFacingLeft() ? this.position.x + this.currentFrame.getRegionWidth() : this.position.x;
        float width = this.orientation.isFacingLeft() ? -this.currentFrame.getRegionWidth() : this.currentFrame.getRegionWidth();

        batch.draw(this.currentFrame, x, this.position.y, width, this.currentFrame.getRegionHeight());
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public float getX() {
        return this.position.x;
    }

    public float getY() {
        return this.position.y;
    }

    public float bottomRightX() {
        return this.bottomLeftX() + this.currentFrame.getRegionWidth();
    }

    public float bottomLeftX() {
        return this.getX();
    }

    public void increaseVerticalSpeedBy(float newVerticalSpeed) {
        this.speed.set(0, newVerticalSpeed);
    }

    private void checkCollisionsWithFloors() {
        if(this.scenario.existsACollisionWith(this)) {
            LevelComponent floor = this.scenario.floorThatCollisionsWith(this);
            this.standOn(floor);
        } else {
            this.state.falling(this);
        }
    }

    public void applySpeed() {
        float newPositionX = this.positionAfterSpeed(this.position.x, this.speed.x);
        float newPositionY = this.positionAfterSpeed(this.position.y, this.speed.y);

        /* This values could be defined in the current Level */
        if(newPositionX >= 0 && newPositionX <= 1800)
            this.position.set(newPositionX, newPositionY);
    }

    public void applyAcceleration() {
        this.speed.add(this.acceleration.x * Gdx.graphics.getDeltaTime(), this.acceleration.y * Gdx.graphics.getDeltaTime());
    }

    private float positionAfterSpeed(float position, float speed) {
        return position + speed * Gdx.graphics.getDeltaTime();
    }

    private void checkKeys() {
        this.setHorizontalSpeedTo(0);

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.run();
            this.setHorizontalSpeedTo(-500);
            this.orientation.faceLeft();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.run();
            this.setHorizontalSpeedTo(500);
            this.orientation.faceRight();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            this.state.jump(this);
            this.justJumped = true;
            this.jumpSound.play(0.2f);
        }

        if(!Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && this.justJumped) {
            this.state.stopJump(this);
            this.justJumped = false;
        }
    }

    private void updateCurrentFrame() {
        this.elapsedTime += Gdx.graphics.getDeltaTime();
        this.currentFrame = this.currentAnimation.getKeyFrame(elapsedTime);
    }

    private void standOn(LevelComponent levelComponent) {
        this.speed.set(this.speed.x, 0);
        this.position.set(this.position.x, levelComponent.getY());
        this.state.grounded(this);
        this.currentAnimation = this.animations.getStandingAnimation();
    }

    private void setHorizontalSpeedTo(float newHorizontalSpeed) {
        this.speed.set(newHorizontalSpeed, this.speed.y);
    }

    public void setAnimation(Animation animation) {
        this.currentAnimation = animation;
    }

    public void run() {
        this.setAnimation(this.animations.getRunningAnimation());
    }

    public void fall() {
        this.increaseVerticalSpeedBy(-600);
        this.setAnimation(this.animations.getJumpingAnimation());
        this.setState(new FallingState());
    }

    public void stand() {
        this.setAnimation(this.animations.getStandingAnimation());
        this.setState(new StandingState());
    }

    public void jump() {
        this.increaseVerticalSpeedBy(600);
        this.setAnimation(this.animations.getJumpingAnimation());
        this.setState(new JumpingState(this.getY()));
    }
}