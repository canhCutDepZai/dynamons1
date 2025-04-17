package canhcut.com;

import canhcut.com.characters.BaseActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BgAlpha extends BaseActor {
    public BgAlpha(Texture texture, float x, float y, Stage s) {
        super(texture, x, y);
        setColor(1,1,1,0.6f);
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        s.addActor(this);

    }
}
