package canhcut.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Objects;

public class BaseActorAnimation extends Actor {
    Animation<TextureRegion> animation;

    float time;

    BaseActorAnimation(Texture texture, float x, float y, Stage s, int cols, int rows) {
        setPosition(x, y);
        setSize(3*texture.getWidth()/cols, 3*texture.getHeight()/rows);
        TextureRegion[][] frameBuff = TextureRegion.split(texture, texture.getWidth() / cols, texture.getHeight() / rows);

        TextureRegion[] frames = new TextureRegion[cols * rows - 1];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!((i == (rows-1)) && (j == (cols-1)))) {
                    frames[index++] = frameBuff[i][j];
                }
            }
        }

        animation = new Animation<TextureRegion>(0.05f, frames);

        animation.setPlayMode(Animation.PlayMode.LOOP);

        time = 0;

      //  s.addActor(this);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        TextureRegion currentFrame = animation.getKeyFrame(time);
        batch.draw(currentFrame, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}
