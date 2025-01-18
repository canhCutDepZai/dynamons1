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

public class BattleScreen implements Screen {

    Master game;
    Character main;
    Character enemy;
    Stage stage;
    BaseActor battleBackground;
    Skills skill1;
    Skills skill2;
    Skills skill3;
    BattleScreen(Master _game){
        this.game = _game;
    }

    @Override
    public void show() {
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.up = new TextureRegionDrawable(new Texture("back.png"));

        TextButton back = new TextButton("", style);
        back.setSize(256, 256);
        back.setPosition((Gdx.graphics.getWidth()/2 - back.getWidth()/2)/15 - 50, (float) ((Gdx.graphics.getHeight()/2 - back.getHeight()/2)*2 +10));

        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new BigMapScreen(game));
            }
        });


        stage = new Stage();
        battleBackground = new BaseActor(new Texture("background1/background1.1.png"), 0, 0);
        battleBackground.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        main = new Character(new Texture("anh/chuot.png"), (float) (Gdx.graphics.getWidth()/5.5), (float) (Gdx.graphics.getHeight()/6), 100, 25, 15, 0);
        main.setScale(1.2F);
        enemy = new Character(new Texture("mons1.png"), (float) (Gdx.graphics.getWidth()/1.9), (float) (Gdx.graphics.getHeight()/2), 150, 10, 10, 0);
        skill1 = new Skills(new Texture("skills.png"), (float) (Gdx.graphics.getWidth()/1.35), (float)(Gdx.graphics.getHeight()/80));
        skill2 = new Skills(new Texture("skills.png"), (float)(Gdx.graphics.getWidth()/1.35 - 140), (float)(Gdx.graphics.getHeight()/80));
        skill3 = new Skills(new Texture("skills.png"), (float)(Gdx.graphics.getWidth()/1.35 - 284), (float)(Gdx.graphics.getHeight()/80));
        stage.addActor(battleBackground);
        stage.addActor(main);
        stage.addActor(enemy);
        stage.addActor(skill1);
        stage.addActor(skill2);
        stage.addActor(skill3);

        stage.addActor(back);
        Gdx.input.setInputProcessor(stage);


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
