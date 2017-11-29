package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Asteroids {

	private Texture texture;
	private Vector2 position;
	private float speed;
	private float scale;
	private float angle;
	private int type;
	private int rotate;
	
	public Asteroids() {
		texture = new Texture("asteroidbrown.png");
		position = new Vector2((float) Math.random() * 1280 + 1280, (float) Math.random() * 736);
		speed = 4 + (float) Math.random() * 2;
		scale = 0.8f + (float) Math.random() * 1.0f;
		angle = 0;
		rotate = (Math.random() * 1) <= 0.5 ? -1 : 1;
		type = (int) (Math.random() * 4);
	}
	
	public void render(SpriteBatch batch){
		batch.draw(texture, position.x - 32, position.y - 32, 32, 32, 64, 64, scale, scale, angle * rotate, type * 64 , 0, 64, 64, false, false);
	}
	
	public void update(){
		angle += scale;
		position.x -= speed;
		if (position.x < -64){
			position.x = (float) Math.random() * 1280 + 1280;
			position.y = (float) Math.random() * 736;
			speed = 4 + (float) Math.random() * 2;
			scale = 0.8f + (float) Math.random() * 1.0f;
		}
	}

}
