package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Background background;
	private Ship ship;
	
	private Asteroids[] asteroids;
	
	static Bullet[] bulletsUp;
	static Bullet[] bulletsDown;
	private Texture textureBullet;
	
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		ship = new Ship();
		asteroids = new Asteroids[15];
		for(int i = 0; i < asteroids.length; i++){
			asteroids[i] = new Asteroids();
		}
		textureBullet = new Texture("Bullet.png");
		bulletsUp = new Bullet[200];
		bulletsDown = new Bullet[200];
		for(int i = 0; i < bulletsUp.length; i++){
			bulletsUp[i] = new Bullet();
			bulletsDown[i] = new Bullet();
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
		for(int i = 0; i < bulletsUp.length; i++){
			if (bulletsUp[i].isActive())
			batch.draw(textureBullet, bulletsUp[i].position.x, bulletsUp[i].position.y);
		}
		for(int i = 0; i < bulletsDown.length; i++){
			if (bulletsDown[i].isActive())
			batch.draw(textureBullet, bulletsDown[i].position.x, bulletsDown[i].position.y);
		}
		batch.end();
	}
	
	public void update(){
		background.update();
		ship.update();
		for(int i = 0; i < asteroids.length; i++){
			asteroids[i].update();
		}
		for(int i = 0; i < bulletsUp.length; i++){
			if (bulletsUp[i].isActive()){
				bulletsUp[i].update();
				for(int j = 0; j < asteroids.length; j++){
					if(asteroids[j].hitArea.contains(bulletsUp[i].position)){
						asteroids[j].takeDamage();
						bulletsUp[i].deactivate();
						break;
					}
				}
			}
		}
		for(int i = 0; i < bulletsDown.length; i++){
			if (bulletsDown[i].isActive()){
				bulletsDown[i].update();
				for(int j = 0; j < asteroids.length; j++){
					if(asteroids[j].hitArea.contains(bulletsDown[i].position)){
						asteroids[j].takeDamage();
						bulletsDown[i].deactivate();
						break;
					}
				}
			}
		}
	}
	
	public void dispose () {
		batch.dispose();
	}
}
