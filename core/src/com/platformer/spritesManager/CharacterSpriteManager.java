package com.platformer.spritesManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CharacterSpriteManager {

    private Texture spritesheet;

    private TextureRegion[] standingFrames;
    private Animation standingAnimation;

    private TextureRegion[] runningFrames;
    private Animation runningAnimation;

    private TextureRegion[] runningAndShootingFrames;
    private Animation runningAndShootingAnimation;

    private TextureRegion[] jumpingFrames;
    private Animation jumpingAnimation;

    private TextureRegion[] jumpingAndShootingFrames;
    private Animation jumpingAndShootingAnimation;

    private TextureRegion[] firingFrames;
    private Animation firingAnimation;

    private TextureRegion[] boltFrames;
    private Animation boltAnimation;

    public CharacterSpriteManager() {
        this.spritesheet = new Texture("spritesheet.png");
        this.initializeBoltFramesAndAnimation();
        this.initializeStandingFramesAndAnimation();
        this.initializeRunningFramesAndAnimation();
        this.initializeRunningAndShootingFramesAndAnimation();
        this.initializeJumpingFramesAndAnimation();
        this.initializeJumpingAndShootingFramesAndAnimation();
        this.initializeFiringFramesAndAnimation();
    }

    private void initializeStandingFramesAndAnimation() {
        this.standingFrames = new TextureRegion[3];
        this.standingFrames[0] = this.spriteAt(1515, 66, 105, 147);
        this.standingFrames[1] = this.spriteAt(1650, 63, 105, 147);
        this.standingFrames[2] = this.spriteAt(1785, 60, 105, 147);

        this.standingAnimation = new Animation(0.15f, this.standingFrames);
        this.standingAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    private void initializeRunningFramesAndAnimation() {
        this.runningFrames = new TextureRegion[12];
        this.runningFrames[0]  = this.spriteAt(143,  480, 103, 147);
        this.runningFrames[1]  = this.spriteAt(270,  471, 121, 147);
        this.runningFrames[2]  = this.spriteAt(435,  474, 117, 147);
        this.runningFrames[3]  = this.spriteAt(585,  471, 144, 147);
        this.runningFrames[4]  = this.spriteAt(920,  474, 100, 147);
        this.runningFrames[5]  = this.spriteAt(1035, 480, 96,  147);
        this.runningFrames[6]  = this.spriteAt(1155, 477, 120, 147);
        this.runningFrames[7]  = this.spriteAt(1305, 477, 114, 147);
        this.runningFrames[8]  = this.spriteAt(1455, 474, 126, 147);
        this.runningFrames[9]  = this.spriteAt(1800, 477, 114, 147);
        this.runningFrames[10] = this.spriteAt(2072, 477, 106, 147);
        this.runningFrames[11] = this.spriteAt(2193, 483, 96,  147);

        this.runningAnimation = new Animation(0.07f, this.runningFrames);
        this.runningAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    private void initializeRunningAndShootingFramesAndAnimation() {
        this.runningAndShootingFrames = new TextureRegion[12];
        this.runningAndShootingFrames[0]  = this.spriteAt(15,   1620, 135, 147);
        this.runningAndShootingFrames[1]  = this.spriteAt(165,  1622, 150, 147);
        this.runningAndShootingFrames[2]  = this.spriteAt(345,  1629, 144, 147);
        this.runningAndShootingFrames[3]  = this.spriteAt(510,  1626, 161, 147);
        this.runningAndShootingFrames[4]  = this.spriteAt(900,  1635, 132, 147);
        this.runningAndShootingFrames[5]  = this.spriteAt(1050, 1635, 117, 147);
        this.runningAndShootingFrames[6]  = this.spriteAt(1200, 1632, 147, 147);
        this.runningAndShootingFrames[7]  = this.spriteAt(1365, 1632, 150, 147);
        this.runningAndShootingFrames[8]  = this.spriteAt(1530, 1628, 159, 147);
        this.runningAndShootingFrames[9]  = this.spriteAt(1875, 1632, 150, 147);
        this.runningAndShootingFrames[10] = this.spriteAt(2190, 1632, 138, 147);
        this.runningAndShootingFrames[11] = this.spriteAt(2355, 1638, 123, 147);

        this.runningAndShootingAnimation = new Animation(0.07f, this.runningAndShootingFrames);
        this.runningAndShootingAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    private void initializeJumpingFramesAndAnimation() {
        this.jumpingFrames = new TextureRegion[4];
        this.jumpingFrames[0]  = this.spriteAt(15,  834, 78, 174);
        this.jumpingFrames[1]  = this.spriteAt(134, 849, 70, 174);
        this.jumpingFrames[2]  = this.spriteAt(255, 855, 69, 174);
        this.jumpingFrames[3]  = this.spriteAt(360, 849, 81, 174);

        this.jumpingAnimation = new Animation(0.07f, this.jumpingFrames);
        this.jumpingAnimation.setPlayMode(Animation.PlayMode.NORMAL);
    }

    private void initializeJumpingAndShootingFramesAndAnimation() {
        this.jumpingAndShootingFrames = new TextureRegion[4];
        this.jumpingAndShootingFrames[0]  = this.spriteAt(2655, 1578, 102, 174);
        this.jumpingAndShootingFrames[1]  = this.spriteAt(2775, 1584, 102, 174);
        this.jumpingAndShootingFrames[2]  = this.spriteAt(2895, 1584, 101, 174);
        this.jumpingAndShootingFrames[3]  = this.spriteAt(3015, 1575, 120, 174);

        this.jumpingAndShootingAnimation = new Animation(0.07f, this.jumpingAndShootingFrames);
        this.jumpingAndShootingAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    private void initializeFiringFramesAndAnimation() {
        this.firingFrames = new TextureRegion[6];
        this.firingFrames[0]  = this.spriteAt(855,  1269, 123, 147);
        this.firingFrames[1]  = this.spriteAt(855,  1269, 123, 147);
        this.firingFrames[2]  = this.spriteAt(855,  1269, 123, 147);
        this.firingFrames[3]  = this.spriteAt(855,  1269, 123, 147);
        this.firingFrames[4]  = this.spriteAt(1005, 1269, 114, 147);
        this.firingFrames[5]  = this.spriteAt(1155, 1272, 105, 147);

        this.firingAnimation = new Animation(0.07f, this.firingFrames);
        this.firingAnimation.setPlayMode(Animation.PlayMode.NORMAL);
    }

    private void initializeBoltFramesAndAnimation() {
        this.boltFrames = new TextureRegion[4];
        this.boltFrames[0] = this.spriteAt(2376, 27,  45, 24);
        this.boltFrames[1] = this.spriteAt(2376, 63,  45, 24);
        this.boltFrames[2] = this.spriteAt(2376, 102, 45, 24);
        this.boltFrames[3] = this.spriteAt(2376, 140, 45, 24);

        this.boltAnimation = new Animation(0.15f, this.boltFrames);
        this.boltAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    private TextureRegion spriteAt(int x, int y, int width, int height) {
        return new TextureRegion(this.spritesheet, x, y, width, height);
    }

    public Animation getBoltAnimation() {
        return this.boltAnimation;
    }

    public Animation getStandingAnimation() {
        return this.standingAnimation;
    }

    public Animation getRunningAnimation() {
        return this.runningAnimation;
    }

    public Animation getRunningAndShootingAnimation() {
        return this.runningAndShootingAnimation;
    }

    public Animation getJumpingAnimation() {
        return this.jumpingAnimation;
    }

    public Animation getJumpingAndShootingAnimation() {
        return this.jumpingAndShootingAnimation;
    }

    public Animation getFiringAnimation() {
        return this.firingAnimation;
    }

}
