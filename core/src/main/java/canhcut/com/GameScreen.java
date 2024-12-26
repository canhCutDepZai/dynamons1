package canhcut.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    Master game;
    Character main;
    Character enemy;
    Stage stage;
    BaseActor background;
    GameScreen(Master _game){
        this.game = _game;
    }

    @Override
    public void show() {
        stage = new Stage();
        background = new BaseActor(new Texture("background1/background1.1.png"), 0, 0);
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        main = new Character(new Texture("anh/chuot.png"), (float) (Gdx.graphics.getWidth()/5.5), (float) (Gdx.graphics.getHeight()/8.4));
        main.setScale(1);
        enemy = new Character(new Texture("mons1.png"), (float) (Gdx.graphics.getWidth()/1.9), (float) (Gdx.graphics.getHeight()/2));
        stage.addActor(background);
        stage.addActor(main);
        stage.addActor(enemy);


    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.LIGHT_GRAY);
        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        game.font.draw(game.batch, "Play", 0, Gdx.graphics.getHeight());
        game.batch.end();


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
