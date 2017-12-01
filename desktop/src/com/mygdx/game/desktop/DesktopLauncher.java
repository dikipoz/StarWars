package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 800;
		config.title = "Аннигилятор";
		config.resizable = false;
		//Gdx.audio.newSound(Gdx.files.internal("matrix.wav")).play(0.08f);
		new LwjglApplication(new MyGdxGame(), config);
	}
}
