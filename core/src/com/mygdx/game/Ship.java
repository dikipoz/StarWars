package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Ship {

	private Vector2 position;
	private float speed;
	private Texture texture;
	private int fireCounter;
	private int fireRate;
	
	public Ship() {
		texture = new Texture("spaceship64.png");
		position = new Vector2(32, 400);
		speed = 7;
		fireRate = 4;
		fireCounter = 0;
	}

	public void render(SpriteBatch batch){
		batch.draw(texture, position.x, position.y);
	}
	
	public void update(){
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			fireCounter++;
			if(fireCounter >= fireRate) {
				fireCounter = 0;
				fire();
			}
		}
		if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
			if(position.x > Gdx.input.getX())
				position.x -= speed;
			if(position.x < Gdx.input.getX())
				position.x += speed;
			if(position.y > 800 - Gdx.input.getY())
				position.y -= speed;
			if(position.y < 800 - Gdx.input.getY())
				position.y += speed;
		}
		
		if (position.x < 0)
			position.x = 0;
		if(position.x > 1280-64)
			position.x = 1280-64;
		if(position.y > 800 - 60)
			position.y = 800-60;
		if(position.y < 0)
			position.y = 0;
	}
	public void fire() {
		for (int i = 0; i < MyGdxGame.bullets.length; i++) {
			if (!MyGdxGame.bullets[i].active) {
				MyGdxGame.bullets[i].activate(position.x, position.y);
				break;
			}
		}
	}
	
	public void dispose(){
		texture.dispose();
	}
}
