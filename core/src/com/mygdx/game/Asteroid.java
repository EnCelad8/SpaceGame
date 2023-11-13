package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private static Texture texture;
    private Vector2 position;
    private float speed;
    //    boolean alive;
    private float rotation;
    private float scale;

    private int hp;

    private final float MIN_SPEED = 400.0f;
    private final float MAX_SPEED = 600.0f;

    public Asteroid() {
        if (texture == null) {
            this.texture = new Texture("asteroid.png");
        }
        this.position = new Vector2(MathUtils.random(1300, 2500), MathUtils.random(0, 720));
        this.speed = MathUtils.random(MIN_SPEED, MAX_SPEED);
        this.rotation = MathUtils.random(0, 360);
        this.scale = MathUtils.random(0.8f, 1.6f);
        this.hp = MathUtils.random(3, 5);
    }

    public void render(SpriteBatch batch) {
        float cscale = 0.8f + hp * 0.2f;
        batch.draw(texture, position.x - 16, position.y - 16, 16, 16, 32, 32,
                cscale, cscale, rotation, 0, 0, 32, 32, false, false);
    }

    public void update(float dt) {
        position.x -= speed * dt;
        rotation += speed * dt / 2.0f;
        if (position.x < -100) {
            recreate();
        }
    }

    public void recreate() {
        this.position.set(MathUtils.random(1350, 2000), MathUtils.random(0, 720));
        this.speed = MathUtils.random(MIN_SPEED, MAX_SPEED);
        this.scale = MathUtils.random(0.8f, 1.6f);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void takeOneDamage() {
        hp--;
        if (hp <= 0) {
            recreate();
        }
    }
}
