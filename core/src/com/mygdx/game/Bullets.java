package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullets {

	private Texture texture;
	private Vector2 position;
	private float speed;
	private boolean active;
	
	public Bullets() {
		texture = new Texture("bullet.png");
		position = new Vector2();
		speed = 25.0f;
		active = false;
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, position.x - 22, position.y);
	}
	
	public void deactivate() {
		active=false;
	}
	
	public void activate(float x, float y) {
		active = true;
		position.set(x, y);
	}
	
	public void update() {
		position.x += speed;
		if (position.x > 1280) {
			deactivate();
		}
	}
	public boolean getActive() {
		return active;
	}
	public void dispose() {
		texture.dispose();
	}
}
