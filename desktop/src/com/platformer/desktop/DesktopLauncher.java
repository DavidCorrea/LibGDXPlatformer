package com.platformer.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.platformer.Platformer;

public class DesktopLauncher {
	public static void main (String[] arg) {
		new LwjglApplication(new Platformer(), gameConfiguration());
	}

	private static LwjglApplicationConfiguration gameConfiguration() {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
		config.title = "LibGDX Platformer";
		return config;
	}
}
