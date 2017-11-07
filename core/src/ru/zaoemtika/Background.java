package ru.zaoemtika;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {

	class Star {
		Vector2 position;
		float speed;
		

		public Star() {
            position = new Vector2((float) Math.random() * 1280, (float) Math.random() * 720);
            speed = 1.0f + (float) Math.random() * 4.0f;
        }

        public void update() {
            position.x -= speed;
            if (position.x < -20) {
                position.x = 1280;
                position.y = (float) Math.random() * 720;
                speed = 1.0f + (float) Math.random() * 4.0f;
            }
        }
	}

	Texture texture;
	Texture textureStar;
	Star[] stars;
	float scale;
	
	public Background() {
		texture = new Texture("space.jpg");
		
		stars = new Star[100];
		textureStar = new Texture("star12.png");
		for(int i = 0; i < stars.length; i++) {
			stars[i] = new Star();
		}
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, 0, 0);
		for (int i = 0; i < stars.length; i++) {
			if(stars[i].speed < 1.5) {
				scale = 0.5f;
			} else if (stars[i].speed >= 1.5 && stars[i].speed < 3.5){
				scale = 0.8f;
			} else if (stars[i].speed >= 3.5 && stars[i].speed < 4.8) {
				scale = 1.1f;
			} else {
				scale = 1.4f;
			}
		batch.draw(textureStar, stars[i].position.x, stars[i].position.y,4,4,8,8,scale,scale,0,0,0,8,8,false,false);
		}
	}

	public void update() {
		for(int i = 0; i < stars.length; i++) {
			stars[i].update();
		}

	}

	public void dispose() {
		texture.dispose();
	}
}
