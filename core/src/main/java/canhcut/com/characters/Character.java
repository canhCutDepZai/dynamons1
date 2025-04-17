package canhcut.com.characters;

import canhcut.com.PokemonNames;
import canhcut.com.Status;
import canhcut.com.screens.BattleScreen;
import canhcut.com.screens.PokemonsDisplay;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Character extends BaseActorAnimation {
    int health;
    int dame;
    int speed;
    float exp;

    PokemonNames name;

    public Status status = Status.POCKET;

    public Character(Texture texture, PokemonNames name, Stage s, int cols, int rows, float x, float y, int _health, int _dame, int _speed, float _exp) {
        super(texture, x, y, s, cols, rows);
        this.health = _health;
        this.dame = _dame;
        this.speed = _speed;
        this.exp = _exp;
        this.name = name;

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                if (status.equals(Status.POCKET) && BattleScreen.characters.contains(Character.this, true)) {
                    int i = BattleScreen.characters.indexOf(Character.this, true);
                    Character character = BattleScreen.characters.removeIndex(i);
                    Stage stage = character.getStage();
                    character.setScale(1 / 3f);
                    BattleScreen.characterAway.add(character);
                    int index = BattleScreen.characterAway.indexOf(character, true);
                    character.setPosition(0 + index * 96, 0);

                    if (!BattleScreen.characters.isEmpty()) {
                        PokemonsDisplay.notHide = BattleScreen.characters.random();
                        PokemonsDisplay.notHide.setColor(1,1,1,1);
                        PokemonsDisplay.notHide.setPosition(Gdx.graphics.getWidth() / 2 - PokemonsDisplay.notHide.getWidth() / 2 - 50 , 245);
                        stage.addActor(PokemonsDisplay.notHide);
                    }

                } else if (status.equals(Status.POCKET) && BattleScreen.characterAway.contains(Character.this, true)) {
                    int i = BattleScreen.characterAway.indexOf(Character.this, true);
                    Character character = BattleScreen.characterAway.removeIndex(i);
                    Stage stage = character.getStage();
                    character.remove();
                    character.setScale(1f);
                    character.setPosition(Gdx.graphics.getWidth() / 2 - character.getWidth() / 2 - 50, 245);
                    BattleScreen.characters.add(character);
                    PokemonsDisplay.notHide = BattleScreen.characters.get(0);
                    stage.addActor(PokemonsDisplay.notHide);

                } else if (status.equals(Status.ATTACK) && BattleScreen.characterAway.contains(Character.this, true)) {
                    int i = BattleScreen.characterAway.indexOf(Character.this, true);
                    BattleScreen.characterAway.swap(i, 0); // đổi phần tử ở vị trí i sang vị trí 0
                }
            }
        });

    }

    @Override
    public void act(float delta) {
        super.act(delta);
//        if(status.equals(Status.ATTACK) || BattleScreen.characterAway.contains(Character.this, true)) {
//            if(name.equals(PokemonNames.PIKACHU)){
//            currentFrame = new TextureRegion(new Texture("avatars/pikachuAvatar.png"));
//            }
//        }
    }
}
