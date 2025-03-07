package canhcut.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class Shadow extends BaseActor{

    Shadow(Texture texture, float x, float y, Stage s) {
        super(texture, x, y);
        this.texture = new TextureRegion(texture);
        setPosition(x, y);
        s.addActor(this);



    }
}
