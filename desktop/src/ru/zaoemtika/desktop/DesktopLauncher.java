package ru.zaoemtika.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.zaoemtika.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width-200;
		//config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height-100;
		config.width = 1280;
		config.height = 720;
		//config.resizable = false;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
