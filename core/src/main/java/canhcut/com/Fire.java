package canhcut.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Fire extends BaseActor{
    Fire(Texture texture, float x, float y, Stage s) {
        super(texture, x, y);
        setPosition(MathUtils.random(50, 200), MathUtils.random(700, 900));
        setRotation(-40);
        s.addActor(this);

        addAction(Actions.sequence(
            Actions.moveBy(300, -250, 0.9f),
            Actions.removeActor()
        ));
    }
}
