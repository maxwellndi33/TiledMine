package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
//
public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img, Background;
    Sprite sprBad;
    TmxMapLoader maploader;
    TiledMap map;
    OrthogonalTiledMapRenderer renderer;
    //private Object cam;
    //private Object mouse_position;
    OrthographicCamera oc;
    Vector3 v3Mouse;

    @Override
    public void create() {
        batch = new SpriteBatch();
        maploader = new TmxMapLoader();
        map = maploader.load("minesweeper.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1);
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        oc.setToOrtho(false, w, h);
        oc.update();
        //img = new Texture("minesweeper.png");
        //sprBad = new Sprite(img);
        //SpriteBatch spriteBatch = new SpriteBatch();
        //Background = new Texture(Gdx.files.internal("minesweeper.png"));
        v3Mouse = new Vector3(0, 0, 0);
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.position.x = Gdx.graphics.getWidth() / 2;
        oc.position.y = Gdx.graphics.getHeight() / 2;


    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.5f, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        movement();
        batch.setProjectionMatrix(oc.combined);
        oc.update();

        //mouse_position.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        oc.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
        batch.begin();
        renderer.setView(oc);
        renderer.render();
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

    private static class OrthogonalCamera extends OrthographicCamera {

        public OrthogonalCamera() {
        }
    }
}
