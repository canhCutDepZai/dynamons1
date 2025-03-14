package canhcut.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Character extends BaseActor {
    int health;
    int dame;
    int speed;
    float exp;

    Character(Texture texture, float x, float y, int _health, int _dame, int _speed, float _exp ) {
        super(texture, x, y);
        this.health = _health;
        this.dame = _dame;
        this.speed = _speed;
        this.exp = _exp;

    }

}
