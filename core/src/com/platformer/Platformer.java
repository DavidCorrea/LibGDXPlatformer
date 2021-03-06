package com.platformer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.platformer.scenario.FirstScenario;
import com.platformer.scenario.FirstScenarioBackground;
import com.platformer.spritesManager.BackgroundSpritesManager;
import com.platformer.model.character.Character;
import com.platformer.spritesManager.HUDManager;
import com.platformer.utils.ScrollingBackground;

public class Platformer extends ApplicationAdapter {
	private SpriteBatch screenBatch;
	private SpriteBatch hudScreenBatch;

	private Camera camera;
	private Character character;

	private FirstScenario scenario;
	private FirstScenarioBackground scenarioBackground;

	private HUDManager hudManager;

	private Music music;
	
	@Override
	public void create () {
		this.screenBatch = new SpriteBatch();
		this.hudScreenBatch = new SpriteBatch();

		this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.camera.update();

		this.scenario = new FirstScenario();
		this.character = new Character(this.scenario);
		this.scenarioBackground = new FirstScenarioBackground(this.camera);

		this.hudManager = new HUDManager();

		this.music = Gdx.audio.newMusic(Gdx.files.internal("Platformer song.mp3"));
		this.music.play();

		Gdx.gl.glClearColor(0, 0, 0, 1);
	}

	@Override
	public void render () {
		this.screenBatch.setProjectionMatrix(this.camera.combined);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.update();
		this.draw();
	}

	@Override
	public void dispose () {
		this.screenBatch.dispose();
		this.music.dispose();
	}

	private void update() {
		this.character.update();
		this.updateCamera();
		this.addFloatingGroundIfClick();
	}

	private void draw() {
		this.screenBatch.begin();

		this.scenarioBackground.drawWith(screenBatch);
		this.scenario.drawWith(screenBatch);
		this.character.drawWith(screenBatch);

		this.screenBatch.end();

		this.hudScreenBatch.begin();
		this.hudScreenBatch.draw(this.hudManager.getHealthBar(), 5, 550, 300, 150);
		this.hudScreenBatch.end();
	}

	private void updateCamera() {
		/* This values could be defined in the current Level */

		if(this.character.getX() >= 700 && this.character.getX() <= 1200) {
			this.camera.position.x = this.character.getX();
		}
		if(this.character.getY() >= 0 && this.character.getY() <= 400) {
			this.camera.position.y = this.character.getY() + 200;
		}

		this.camera.update();
	}

	private Vector3 cameraPosition() {
		return this.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
	}

	private void addFloatingGroundIfClick() {
		if(Gdx.input.justTouched()) {
			this.scenario.addFloatingGround(cameraPosition().x, cameraPosition().y);
		}
	}
}
