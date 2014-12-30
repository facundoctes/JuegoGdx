package com.mygdx.game.android;

import android.graphics.Color;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Facundo on 30/12/2014.
 */
public class Pantalla implements ApplicationListener{

    Pixmap pixmap;
    Texture texture;
    SpriteBatch batcher;

    @Override
    public void create() {

        pixmap = new Pixmap(200,200,Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fillRectangle(0,0,200,200);

        texture = new Texture(pixmap);
        texture.bind();

        batcher = new SpriteBatch();

    }

    @Override
    public void resize(int width, int height) {
      /// No vamos a usar por el momento.
    }

    @Override
    public void render() {
       // Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT | GL10.GL_STENCIL_BUFFER_BIT);

        batcher.begin();
        batcher.draw(texture,0,0);
        batcher.end();
    }

    @Override
    public void pause() {
        batcher.dispose();
        texture.dispose();
        pixmap.dispose();
    }

    @Override
    public void resume() {
        pixmap = new Pixmap(200,200,Pixmap.Format.RGB888);
        pixmap.setColor(Color.GREEN);
        pixmap.fillRectangle(0,0,200,200);

        texture = new Texture(pixmap);
        texture.bind();

        batcher = new SpriteBatch();

    }

    @Override
    public void dispose() {
        batcher.dispose();
        texture.dispose();
        pixmap.dispose();
    }
}
