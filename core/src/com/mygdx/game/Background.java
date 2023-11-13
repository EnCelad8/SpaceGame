package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Background {
    private Texture texture;
    private Texture textureStar;
    Star[] stars;
    private class Star {

        private final float MIN_SPEED = 20.0f;
        private final float MAX_SPEED = 200.0f;
        private Vector2 position;
        private float speed;

        public float getMIN_SPEED() {
            return MIN_SPEED;
        }

        public float getMAX_SPEED() {
            return MAX_SPEED;
        }

        public Star() {
            position = new Vector2(1600 * (float) Math.random(), 720 * (float) Math.random());
            speed = MathUtils.random(MIN_SPEED, MAX_SPEED);
        }
        public void update(float dt){
            position.x -= speed * dt;
            if (position.x < -50){
                position.x = 1280;
                position.y = 720 * (float) Math.random();
                speed = MathUtils.random(MIN_SPEED, MAX_SPEED);
            }
        }
    }

    public Background() {
        this.texture = new Texture("background.png");
        this.textureStar = new Texture("sparkle.png");
        stars = new Star[400];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, 0, 0);
        for (int i = 0; i < stars.length; i++) {
            float scale = 0.2f + stars[i].speed / stars[i].MAX_SPEED;
            batch.draw(textureStar,
                    stars[i].position.x ,
                    stars[i].position.y ,
                    8,
                    8,
                    16,
                    16,
                    scale,
                    scale,
                    0,
                    0,
                    0,
                    16,
                    16,
                    false,
                    false);
            if (Math.random() < 0.01f){
                scale *= 1.5f;
                batch.draw(textureStar,
                        stars[i].position.x ,
                        stars[i].position.y ,
                        8,
                        8,
                        16,
                        16,
                        scale,
                        scale,
                        0,
                        0,
                        0,
                        16,
                        16,
                        false,
                        false);
            }
        }
    }

    public void update(float dt) {
        for (int i = 0; i < stars.length; i++) {
            stars[i].update(dt);
        }
    }
}
