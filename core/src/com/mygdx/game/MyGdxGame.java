package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Background background;
	private Ship ship;
	private Asteroids[] asteroids;
	static Bullet[] bullets;
	
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		ship = new Ship();
		asteroids = new Asteroids[15];
		for(int i = 0; i < asteroids.length; i++){
			asteroids[i] = new Asteroids();
		}
		bullets = new Bullet[200];
		for(int i = 0; i < bullets.length; i++){
			bullets[i] = new Bullet();
		}
	}

	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		ship.render(batch);
		
		for(int i = 0; i < asteroids.length; i++){
			asteroids[i].render(batch);
		}
		for(int i = 0; i < bullets.length; i++){
			bullets[i].render(batch);
		}
		batch.end();
	}
	
	public void update(){
		background.update();
		ship.update();
		for(int i = 0; i < asteroids.length; i++){
			asteroids[i].update();
		}
		for(int i = 0; i < bullets.length; i++){
			if (bullets[i].isActive()){
				bullets[i].update();
			}
		}
		
	}
	
	public void dispose () {
		batch.dispose();
	}
}
