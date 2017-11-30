package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {

	private Texture texture;
	private Texture textureStars;
	private Stars[] stars;
	
	
	
	class Stars{
		float speed;
		Vector2 position;
		float size;
		
		Stars(){
			position = new Vector2((float) Math.random() * 1280, (float) Math.random() * 800);
			speed = 1 + (float) Math.random() * 1;
			if (speed < 0.5){
				size = 0.3f;
			}
			if (size >=0.5 && size < 1.5){
				size = 0.4f;
			}
			if (speed >= 1.5){
				size = 0.5f;
			}
		}
		
		public void update(){
			position.x -= speed;
			if (position.x < 0){
				position.x = 1280;
				position.y = (float) Math.random() * 800;
				speed = 1 + (float) Math.random() * 3;
				if (speed < 1){
					size = 0.3f;
				}
				if (size >=1 && size < 2){
					size = 0.4f;
				}
				if (speed >= 2){
					size = 0.5f;
				}
			}
		}
		
	}
	
	
	public Background() {
		texture = new Texture("space1289.png");
		textureStars = new Texture("star16.png");
		
		stars = new Stars[50];
		for(int i = 0; i < stars.length; i++){
			stars[i] = new Stars();
		}
	}
	float t = 0;
	public void render(SpriteBatch batch){
		batch.draw(texture, -t, 0);
		batch.draw(texture, -t + 1280, 0);
		
		for(int i = 0; i < stars.length; i++){
			batch.draw(textureStars, stars[i].position.x, stars[i].position.y, 8,8,16,16,stars[i].size,stars[i].size,0,0,0,16,16,false,false);
		}
	}
	
	public void update(){
		t += 0.3f;
		if (t > 1280) t -= 1280;
		for(int i = 0; i < stars.length; i++){
			stars[i].update();
		}
	}
	
	public void dispose(){
		texture.dispose();
		textureStars.dispose();
	}

}
