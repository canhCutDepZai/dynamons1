package canhcut.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Character extends BaseActorAnimation {
    int health;
    int dame;
    int speed;
    float exp;

    PokemonNames name;

    Status status = Status.POCKET;

    Character(Texture texture, PokemonNames name, Stage s, int cols, int rows, float x, float y, int _health, int _dame, int _speed, float _exp ) {
        super(texture, x, y, s, cols, rows);
        this.health = _health;
        this.dame = _dame;
        this.speed = _speed;
        this.exp = _exp;
        this.name = name;

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(status.equals(Status.POCKET)){
                    status = Status.TAKE;
                    remove();
                } else if (status.equals(Status.TAKE)) {
                    status = Status.ATTACK;
                }
            }
        });

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(status.equals(Status.TAKE)){
            if(name.equals(PokemonNames.PIKACHU))
            currentFrame = new TextureRegion(new Texture("avatars/pikachuAvatar.png"));
        }
    }
}
