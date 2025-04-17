package canhcut.com.screens;

import canhcut.com.*;
import canhcut.com.buttons.MoreButton;
import canhcut.com.characters.Character;
import canhcut.com.characters.BaseActor;
import canhcut.com.characters.BaseActorAnimation;
import canhcut.com.skills.Skills;
import canhcut.com.skills.UltimateSkill;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;


public class BattleScreen implements Screen {

    Master game;
    BaseActorAnimation enemy;
    Stage stage;
    BaseActor battleBackground;
    Skills skill1;
    Skills skill2;
    UltimateSkill ulti;
    Music battleMusic;

    BaseActor attribute;
    MoreButton moreButton;

    // danh sach chua cac pokemon o trong kho
    public static Array<Character> characters = new Array<>();
    // danh sach cac pokemon mang di
    public static Array<Character> characterAway = new Array<>();

    public BattleScreen(Master _game) {
        this.game = _game;
    }

    @Override
    public void show() {

        battleMusic = Gdx.audio.newMusic(Gdx.files.internal("09 Battle! Pokemon Trainer.mp3"));
        battleMusic.setLooping(true);
        battleMusic.setVolume(.5f);
        battleMusic.play();


        stage = new Stage();
        battleBackground = new BaseActor(new Texture("battleScreen.jpg"), 0, 0);
        stage.addActor(battleBackground);

        battleBackground.setSize(960, 540);

        attribute = new BaseActor(new Texture("attribute.png"), 660, 20);
        attribute.setScale(2f);


        enemy = new BaseActorAnimation(new Texture("charmeleon.png"), 680, 270, stage, 5, 18);
        float x = Gdx.graphics.getWidth() - 96;
        skill1 = new Skills(new Texture("fire1.png"), x, (float) (Gdx.graphics.getHeight() / 80), 2);
        skill2 = new Skills(new Texture("fire2.png"), x - 96 - 10, (float) (Gdx.graphics.getHeight() / 80), 2);
        ulti = new UltimateSkill(new Texture("fireRain.png"), x - 96 - 20 - 96, (float) (Gdx.graphics.getHeight() / 80));

        stage.addActor(skill1);
        stage.addActor(skill2);
        stage.addActor(ulti);
        stage.addActor(attribute);


        Gdx.input.setInputProcessor(stage);

        moreButton = new MoreButton(new Texture("buttons.png"), 0, 0, stage, 0, game);

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
        battleMusic.stop();

    }

    @Override
    public void dispose() {

    }
}
