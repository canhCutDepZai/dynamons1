package canhcut.com.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BaseActorAnimation extends Actor {
    public Animation<TextureRegion> animation;
    TextureRegion currentFrame;
    float time;

    public BaseActorAnimation(Texture texture, float x, float y, Stage s, int cols, int rows) {
        setPosition(x, y);
        setSize(3 * texture.getWidth() / cols, 3 * texture.getHeight() / rows);
        TextureRegion[][] frameBuff = TextureRegion.split(texture, texture.getWidth() / cols, texture.getHeight() / rows);

        TextureRegion[] frames = new TextureRegion[cols * rows];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                frames[index++] = frameBuff[i][j];
            }
        }

        animation = new Animation<TextureRegion>(0.05f, frames);

        animation.setPlayMode(Animation.PlayMode.LOOP);

        time = 0;

        s.addActor(this);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
        currentFrame = animation.getKeyFrame(time);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
        batch.draw(currentFrame, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(1, 1, 1, 1);
    }

    public void setAnimation(Texture texture, int cols, int rows) {
        setSize(3 * texture.getWidth() / cols, 3 * texture.getHeight() / rows);
        TextureRegion[][] frameBuff = TextureRegion.split(texture, texture.getWidth() / cols, texture.getHeight() / rows);

        TextureRegion[] frames = new TextureRegion[cols * rows];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                frames[index++] = frameBuff[i][j];
            }
        }

        animation = new Animation<TextureRegion>(0.05f, frames);

        animation.setPlayMode(Animation.PlayMode.LOOP);

    }
}
