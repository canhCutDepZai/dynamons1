package canhcut.com.screens;

import canhcut.com.Master;
import canhcut.com.ScreenName;
import canhcut.com.Status;
import canhcut.com.characters.Character;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

public class PokedexScreen implements Screen {
    Master game;
    Stage stage;

    PokedexScreen(Master _game) {
        this.game = _game;
        stage = new Stage();

    }

    @Override
    public void show() {
        game.screenName = ScreenName.POKEDEXSCREEN;

        Gdx.input.setInputProcessor(stage);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.up = new TextureRegionDrawable(new Texture("back.png"));

        TextButton back = new TextButton("", style);
        back.setPosition(200, 200);
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.pokemonsDisplayScreen);
            }
        });
        stage.addActor(back);
        stage.addActor(PokemonsDisplay.notHide);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 0);

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

    }

    @Override
    public void dispose() {

    }
}
