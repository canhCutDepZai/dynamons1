package canhcut.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;


public class BattleScreen implements Screen {

    Master game;
    BaseActor main;
    BaseActorAnimation enemy;
    Stage stage;
    BaseActor battleBackground;
    Skills skill1;
    Skills skill2;
    Skills skill3;

    BaseActor ballBack;
    MoreButton moreButton;
    Shadow mainShadow, enemyShadow;



//    static Boolean skillActive = false;

    BattleScreen(Master _game){
        this.game = _game;
    }

    @Override
    public void show() {
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.up = new TextureRegionDrawable(new Texture("back.png"));

//        TextButton back = new TextButton("", style);
//        back.setSize(256, 256);
//        back.setPosition((Gdx.graphics.getWidth()/2 - back.getWidth()/2)/15 - 50, (float) ((Gdx.graphics.getHeight()/2 - back.getHeight()/2)*2 +10));

//        back.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                game.setScreen(new BigMapScreen(game));
//            }
//        });


        stage = new Stage();
        battleBackground = new BaseActor(new Texture("background1/background1.1.png"), 0, 0);
        battleBackground.setSize(540, 960);
        main = new BaseActor(new Texture("dynamonsback1.png"), (float) (Gdx.graphics.getWidth()/5.7), (float) (Gdx.graphics.getHeight()/6));
        main.setScale(0);
        enemy = new BaseActorAnimation(new Texture("charmeleon.png"), 540, (float) (Gdx.graphics.getHeight()/2.3), stage, 5, 18);
        enemy.setSize(69, 56);
        float x = Gdx.graphics.getWidth() - 96;
        skill1 = new Skills(new Texture("fire3.png"), x, (float)(Gdx.graphics.getHeight()/80), 1);
        skill2 = new Skills(new Texture("fire2.png"), x - 96 -10, (float)(Gdx.graphics.getHeight()/80), 2);
        skill3 = new Skills(new Texture("fire1.png"), x - 96-20-96, (float)(Gdx.graphics.getHeight()/80), 2);
        ballBack = new BaseActor(new Texture("ballBack.png"), 0, 160);
        ballBack.setSize(64, 64);
        ballBack.setOrigin(ballBack.getWidth()/2, ballBack.getHeight()/2);

        stage.addActor(battleBackground);
        stage.addActor(main);
        stage.addActor(enemy);
        stage.addActor(skill1);
        stage.addActor(skill2);
        stage.addActor(skill3);


        Gdx.input.setInputProcessor(stage);

        enemy.addAction(Actions.sequence(Actions.moveTo(300, (float) (Gdx.graphics.getHeight()/2.3), 1)));
        ballBack.addAction(Actions.moveTo(95, 230, 0.5F));
        ballBack.addAction(Actions.rotateBy(-360, 0.5F));
        ballBack.addAction(Actions.color(new Color(1,1,1,0), 1));
        main.setColor(Color.CLEAR);
        main.addAction(Actions.scaleTo(0.6F, 0.6F, 1));
        main.addAction(Actions.color(new Color(1,1,1,1), 1));
        mainShadow = new Shadow(new Texture("shadow.png"),(float) (Gdx.graphics.getWidth()/5.7)+50, (float) (Gdx.graphics.getHeight()/6)+35, stage);
        mainShadow.setColor(1,1,1,1.5f);
        mainShadow.setScale(1, 1.5f);
        enemyShadow = new Shadow(new Texture("shadow.png"), 300, (float) (Gdx.graphics.getHeight()/2.3), stage);
        enemyShadow.setColor(1,1,1,1.5f);
        enemyShadow.setScale(1, 1.5f);



        moreButton = new MoreButton(new Texture("buttons.png"), 0, 0,stage, 0, game);



//        main.addAction(Actions.sequence(
//            Actions.run(() -> {
//                    ballBack.texture = new TextureRegion(new Texture("ballBack.png"));
//                    ballBack.addAction(Actions.moveTo(95, 960 / 6, 1));
//            }
//                ),
//
//        ));
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
