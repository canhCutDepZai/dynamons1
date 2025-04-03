package canhcut.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.compression.lzma.Base;

import static canhcut.com.BattleScreen.characters;

public class PokemonsDisplay implements Screen {
    Master game;
    Stage stage;

    PokemonsDisplay(Master _game) {
        this.game = _game;
        stage = new Stage();

        Character mewtwo = new Character(new Texture("mewtwo.png"), PokemonNames.MEWTWO, stage, 5, 25, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 100, 25, 12, 0);
        characters.add(mewtwo);
        Character pikachu = new Character(new Texture("pikachu.png"),PokemonNames.PIKACHU, stage, 3, 38, 60, 32, 50, 12, 10, 0);
        characters.add(pikachu);
//        Character dragonite = new Character(new Texture("dragonite.png"), PokemonNames.DRAGONITE, stage, 6, 17, 60, 32, 150, 20, 9, 0);
//        characters.add(dragonite);

        for(int i = 0; i < characters.size - 1; i++) {
            if(characters.get(i).status != Status.POCKET) {
                characters.get(i).remove();
            }
        }

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;

        TextButton start = new TextButton("Go to Bigmap !!", style);
        start.setPosition(Gdx.graphics.getWidth()/2 - start.getWidth()/2, Gdx.graphics.getHeight()/6 - start.getHeight()/2);
        start.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new BigMapScreen(game));
            }
        });

        TextButton show = new TextButton("Pockedex Show !!", style);
        show.setPosition(Gdx.graphics.getWidth()/2 - show.getWidth()/2, Gdx.graphics.getHeight()/4);
        show.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PokedexScreen(game));
            }
        });

        stage.addActor(start);
        stage.addActor(show);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
//        BaseActor background = new BaseActor(new Texture("DisplayBackground.jpg"), 0, 0);
//        stage.addActor(background);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0,0,0,0);

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void dispose() {

    }
}
