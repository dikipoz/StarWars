package ru.zaoemtika;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Ship {
	
	Vector2 position;
	Texture texture;
	float speed;
	int fireSpeed;
	int fireCount;
	
	public Ship() {
		texture = new Texture("ship.png");
		position = new Vector2(100, 328);
		speed = 8f;
		fireSpeed = 4;
		fireCount = 0;
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(texture, position.x, position.y);
	}
	
	
	public void update() {
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			position.y += speed-5;
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			position.y -= speed-5;
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			position.x -= speed;
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			position.x += speed;
		}
		if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
            if (position.x + 32 > Gdx.input.getX()) {
                position.x -= speed;
            }
            if (position.x + 32 < Gdx.input.getX()) {
                position.x += speed;
            }
            if (position.y + 32 > 720 - Gdx.input.getY()) {
                position.y -= speed;
            }
            if (position.y + 32 < 720 - Gdx.input.getY()) {
                position.y += speed;
            }
        }
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			fireCount++;
            if (fireCount >= fireSpeed) {
                fireCount = 0;
                fire();
            }
		}
		
		if (position.x <= 0) {
			position.x = 0;
		}
		if(position.x > 1280 - 64) {
			position.x = 1280 - 64;
		}
		if(position.y <0) {
			position.y = 0;
		}
		if (position.y > 720 - 64) {
			position.y = 720 - 64;
		}
	}
	
	public void fire() {
        for (int i = 0; i < MyGdxGame.bullets.length; i++) {
            if (!MyGdxGame.bullets[i].activation) {
                MyGdxGame.bullets[i].activate(position.x + 48, position.y + 32);
                break;
            }
        }
    }

}
