package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet {

	
	Vector2 position;
	private float speed;
	private boolean active;
	
	
	public boolean isActive() {
		return active;
	}

	public Bullet() {
		
		position = new Vector2(0,0);
		speed = 20.0f;
		active = false;
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
		if (position.x > 1300){
			deactivate();
		}
	}

}
