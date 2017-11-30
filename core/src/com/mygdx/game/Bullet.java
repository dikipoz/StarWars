package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet {

	private Texture texture;
	Vector2 position;
	private float speed;
	private boolean active;
	
	
	public boolean isActive() {
		return active;
	}

	public Bullet() {
		texture = new Texture("Bullet.png");
		position = new Vector2(0,0);
		speed = 15.0f;
		active = false;
	}
	
	public void render(SpriteBatch batch){
		batch.draw(texture, position.x - 10, position.y);
	}
	
	public void deactivate(){
		active = false;
	}
	
	public void activate(float x, float y){
		position.set(x, y);
		active = true;
	}
	
	public void update(){
		position.x += speed;
		if (position.x > 1280){
			deactivate();
		}
	}

}
