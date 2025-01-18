package canhcut.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

public class BigMapScreen implements Screen {
    Master game;
    Stage stage;
    BaseActor bigmapBackground;

    BigMapScreen(Master _game) {

        this.game = _game;
    }



    @Override
    public void show() {
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.up = new TextureRegionDrawable(new Texture("play.png"));

        TextButton begin = new TextButton("", style);
        begin.setPosition(Gdx.graphics.getWidth()/2 - begin.getWidth()/2, Gdx.graphics.getHeight()/2 - begin.getHeight()/2);


        begin.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new BattleScreen(game));
            }
        });

        stage = new Stage();

        bigmapBackground = new BaseActor(new Texture("bigmap.jpg"), 0,0);
        bigmapBackground.setSize(540, 960);
        stage.addActor(bigmapBackground);

        stage.addActor(begin);
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
