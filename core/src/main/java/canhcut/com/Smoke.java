package canhcut.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Smoke extends BaseActor{
    Smoke(Texture texture, float x, float y, Stage s) {
        super(texture, x, y);
        setPosition(680, 270);
        setSize(texture.getWidth(), texture.getHeight());
        s.addActor(this);

        addAction(Actions.sequence(
            Actions.moveBy( -20, 0, 0.75f),
            Actions.moveBy(20, 0, 0.75f),
            Actions.removeActor()
        )
        );
        addAction(Actions.fadeOut(1.75f));

    }
}
