package ru.zaoemtika;

import com.badlogic.gdx.math.Vector2;

public class Bullet {

	Vector2 position;
	float speed;
	boolean activation;
	
	public Bullet() {
		position = new Vector2(0,0);
		speed = 15f;
		activation = false;
	}
	
	public void activate(float x, float y) {
		activation = true;
		position.set(x, y);
	}
	
	
	public void deactivate() {
		activation = false;
	}
	
	
	public void update() {
		position.x += speed;
		if (position.x > 1280) {
			activation = false;
		}
	}
}
