package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Asteroids {

	private static Texture texture;
	private Vector2 position;
	private float speed;
	private float scale;
	private float angle;
	private int type;
	private int rotate;
	Circle hitArea;
	private Sound soundExplose;
	int hp;
	int maxHp;

	public Asteroids() {
		if (texture == null) {
			texture = new Texture("asteroidbrown.png");
		}
		soundExplose = Gdx.audio.newSound(Gdx.files.internal("soundExplose2.mp3"));
		position = new Vector2((float) Math.random() * 1280 + 1280, (float) Math.random() * 736);
		speed = 2 + (float) Math.random() * 2;
		
		angle = 0;
		rotate = (Math.random() * 1) <= 0.5 ? -1 : 1;
		type = (int) (Math.random() * 4);
	
		scale = 1.3f + type * 0.1f;
		maxHp = (int) (type) + 5;
		hp = maxHp;
		hitArea = new Circle(position, 27 * scale);
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, position.x - 32, position.y - 32, 32, 32, 64, 64, scale, scale, angle * rotate, type * 64,
				0, 64, 64, false, false);
	}
	
	public void recreate(){
		position.x = 1280 + (float) Math.random() * 1280;
		position.y = (float) Math.random() * 716;
		speed = 2 + (float) Math.random() * 2;
		
		angle = 0;
		rotate = (Math.random() * 1) <= 0.5 ? -1 : 1;
		type = (int) (Math.random() * 4);
		scale = 1f + type * 0.1f;
		maxHp = (int) (type) + 5;
		hp = maxHp;
		hitArea.radius = 27 * scale;
		//System.out.println(scale + "   " + hitArea.radius);
	}

	public void takeDamage() {
		hp--;
		if (hp <= 0){
			soundExplose.play(0.1f);
			recreate();
		}

	}

	public void update() {
		angle += scale;
		position.x -= speed;
		if (position.x < -64) {
			recreate();
		}
		hitArea.x = position.x;
		hitArea.y = position.y;
	}

}
