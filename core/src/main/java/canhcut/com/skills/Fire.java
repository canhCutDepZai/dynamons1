package canhcut.com.skills;

import canhcut.com.characters.BaseActor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Fire extends BaseActor {
    Fire(Texture texture, float x, float y, Stage s) {
        super(texture, x, y);
        setPosition(MathUtils.random(480, 640), MathUtils.random(480, 540));
        setRotation(-55);
        s.addActor(this);

        addAction(Actions.sequence(
            Actions.moveBy(300, -200, 0.9f),
            Actions.removeActor()
        ));
    }
}
