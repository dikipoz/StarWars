package ru.zaoemtika;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background background;
	Ship ship;
	Texture textureBullet;
	static Bullet[] bullets;
	
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		ship = new Ship();
		textureBullet = new Texture("bullet64x32.png");
		bullets = new Bullet[200]; 
		for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }
	}

	public void render () {
		update();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		ship.render(batch);
		for(int i = 0; i<bullets.length; i++) {
			if (bullets[i].activation) {
				batch.draw(textureBullet, bullets[i].position.x - 32, bullets[i].position.y - 16);
			}
			
			
		}
		batch.end();
	}
	
	public void update() {
		background.update();
		ship.update();
		for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].activation) {
                bullets[i].update();
            }
        }
	}
	
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
