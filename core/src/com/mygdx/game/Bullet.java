package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
    private static Texture texture;
    private Vector2 position;
    private float speed;
    private boolean alive;

    public boolean isAlive() {
        return alive;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Bullet() {
        if (texture == null) {
            this.texture = new Texture("bullets.png");
        }
        this.position = new Vector2(0, 0);
        this.speed = 400.0f;
        this.alive = false;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 32, position.y - 16);
    }

    public void update(float dt) {
        position.x += speed * dt;
        if (position.x > 1280) {
            alive = false;
        }
    }

    public void setup(Vector2 position) {
        this.position.set(position);
        alive = true;
    }

    public void destroy(){
        alive = false;
    }
}
