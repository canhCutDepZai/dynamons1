package canhcut.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Skills extends Actor{
    TextureRegion texture;

    Skills(Texture texture, float x, float y ){
        this.texture = new TextureRegion(texture);
        setPosition(x, y);
        setSize(128, 128);
    }

    @Override
    public void draw(Batch batch, float parentAlpha)  {
        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
  }
