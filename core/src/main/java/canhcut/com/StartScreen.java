package canhcut.com;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class StartScreen implements Screen {
    Master game;
    BaseActor startBackground;
    Stage stage;

    StartScreen(Master _game) {

        this.game = _game;
    }

    @Override
    public void show() {

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.up = new TextureRegionDrawable(new Texture("play.png"));
        style.down = new TextureRegionDrawable(new Texture("playdown.png"));

        TextButton start = new TextButton("", style);
        start.setPosition(Gdx.graphics.getWidth()/2 - start.getWidth()/2, Gdx.graphics.getHeight()/6 - start.getHeight()/2);

        start.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new BigMapScreen(game));
            }
        });

        stage = new Stage();

        startBackground = new BaseActor(new Texture("background1/background0.jpg"), 0, 0);
        startBackground.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.addActor(startBackground);

        stage.addActor(start);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float v) {
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
