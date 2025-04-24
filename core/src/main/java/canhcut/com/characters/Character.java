package canhcut.com.characters;

import canhcut.com.Master;
import canhcut.com.PokemonNames;
import canhcut.com.ScreenName;
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
    static boolean viTri1 = false;
    static boolean viTri2 = false;
    static boolean viTri3 = false;

    public int position = 0;

    PokemonNames name;
    public Avatar avatar;

    public Status status = Status.POCKET;

    public Character(Texture texture, PokemonNames name, Stage s, int cols, int rows, float x, float y, int _health, int _dame, int _speed, float _exp) {
        super(texture, x, y, s, cols, rows);
        this.health = _health;
        this.dame = _dame;
        this.speed = _speed;
        this.exp = _exp;
        this.name = name;

        switch (name) {
            case MEWTWO -> {
                avatar = new Avatar(new Texture("avatars/pikachuAvatar.png"), name);
            }
            case PIKACHU -> {
                avatar = new Avatar(new Texture("avatars/pikachuAvatar.png"), name);
            }
            case DRAGONITE -> {
                avatar = new Avatar(new Texture("avatars/pikachuAvatar.png"), name);
            }
            default -> {
                avatar = new Avatar(new Texture("avatars/pikachuAvatar.png"), name);
            }
        }

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                if (!Master.screenName.equals(ScreenName.POKEDEXSCREEN)) {
                    if (status.equals(Status.POCKET) && BattleScreen.characters.contains(Character.this, true) && BattleScreen.characterAway.size < 3) {

                        int i = BattleScreen.characters.indexOf(Character.this, true);
                        Character character = BattleScreen.characters.removeIndex(i);
                        character.setScale(1/3f);
                        Stage stage = character.getStage();
                        BattleScreen.characterAway.add(character);
                        if (!viTri1) {
                            viTri1 = true;
                            character.setPosition(0, 0);
                        } else if (!viTri2) {
                            viTri2 = true;
                            character.setPosition(96, 0);
                        } else if (!viTri3) {
                            viTri3 = true;
                            character.setPosition(96 * 2, 0);
                        }

                        if (!BattleScreen.characters.isEmpty()) {
                            PokemonsDisplay.notHide = BattleScreen.characters.random();
                            PokemonsDisplay.notHide.setColor(1, 1, 1, 1);
                            PokemonsDisplay.notHide.setPosition(Gdx.graphics.getWidth() / 2 - PokemonsDisplay.notHide.getWidth() / 2 - 50, 245);
                            stage.addActor(PokemonsDisplay.notHide);
                        }

                    } else if (status.equals(Status.POCKET) && BattleScreen.characterAway.contains(Character.this, true)) {
                        int i = BattleScreen.characterAway.indexOf(Character.this, true);
                        Character character = BattleScreen.characterAway.removeIndex(i);
                        character.setScale(1f);
                        Stage stage = character.getStage();
                        character.remove();
                        if (character.getX() == 0 & character.getY() == 0) {
                            viTri1 = false;
                        } else if (character.getX() == 96 & character.getY() == 0) {
                            viTri2 = false;
                        } else if (character.getX() == 96 * 2 & character.getY() == 0) {
                            viTri3 = false;
                        }
                        character.setPosition(Gdx.graphics.getWidth() / 2 - character.getWidth() / 2 - 50, 245);
                        BattleScreen.characters.add(character);
                        PokemonsDisplay.notHide = BattleScreen.characters.get(0);
                        stage.addActor(PokemonsDisplay.notHide);

                    }
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
