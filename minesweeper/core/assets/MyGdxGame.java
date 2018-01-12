package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//
public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img, Background;
    Sprite sprBad;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("minesweeper.png");
        sprBad = new Sprite(img);
        //SpriteBatch spriteBatch = new SpriteBatch();
        Background = new Texture(Gdx.files.internal("minesweeper.png"));

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.5f, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        movement();
        batch.begin();
        batch.draw(Background, 70, 35);
        //sprBad.draw(batch);
        batch.end();
    }

    public void movement() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            sprBad.setX(sprBad.getX() - 5);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            sprBad.setX(sprBad.getX() + 5);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            sprBad.setY(sprBad.getY() + 5);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            sprBad.setY(sprBad.getY() - 5);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        Background.dispose();
        img.dispose();
    }
}
