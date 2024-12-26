package canhcut.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Character extends BaseActor {

    Character(Texture texture, float x, float y ){
        super(texture, x, y);
        setScale(2);
    }

}
