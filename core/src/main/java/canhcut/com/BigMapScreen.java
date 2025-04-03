package canhcut.com;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
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
    Music music;
    Area area1, area2, area3, area4, area5, area6, area7, area8, area9, area10, area11, area12, area13, area14, area15, area16, area17, area18;

    BigMapScreen(Master _game) {

        this.game = _game;
    }

    float lastTouchX;
    float lastTouchY;
    boolean isDragging = false ;

    Stage stage1;




    @Override
    public void show() {

        stage = new Stage();
        stage1 = new Stage();

        music = Gdx.audio.newMusic(Gdx.files.internal("02 Title Screen.mp3"));
        music.setVolume(.5f);
        music.setLooping(true);
        music.play();

        bigmapBackground = new BaseActor(new Texture("bigmap.png"), 0,0);
        bigmapBackground.setSize(1080, 540);
        stage.addActor(bigmapBackground);

        area1 = new Area(new Texture("elip.png"), 64, 254, stage1, 1 , game);
        area2 = new Area(new Texture("elip.png"), 128, 254+64, stage1, 1 , game);
        area3 = new Area(new Texture("elip.png"), 254, 254+64, stage1, 1 , game);
        area4 = new Area(new Texture("elip.png"), 254, 100, stage1, 1 , game);
        area5 = new Area(new Texture("elip.png"), 30, 200, stage1, 1 ,game);
        area6 = new Area(new Texture("elip.png"), 322, 593, stage1, 1 , game);
        area7 = new Area(new Texture("elip.png"), 274, 655, stage1, 1 , game);
        area8 = new Area(new Texture("elip.png"), 381, 657, stage1, 1 , game);
        area9 = new Area(new Texture("elip.png"), 536, 705, stage1, 1, game);
        area10 = new Area(new Texture("elip.png"), 708, 705, stage1, 1, game);
        area11 = new Area(new Texture("elip.png"), 858, 200, stage1, 1, game);
        area12 = new Area(new Texture("elip.png"), 994, 659, stage1, 1, game);
        area13 = new Area(new Texture("elip.png"), 1000, 622, stage1, 1, game);
        area14 = new Area(new Texture("elip.png"), 1020, 343, stage1, 1, game);
        area15 = new Area(new Texture("elip.png"), 956, 500, stage1, 1, game);
        area16 = new Area(new Texture("elip.png"), 576, 343, stage1, 1, game);
        area17 = new Area(new Texture("elip.png"), 666, 403, stage1, 1, game);
        area18 = new Area(new Texture("elip.png"), 770, 378, stage1, 1, game);


//        stage.addActor(begin);

        InputMultiplexer multiPlexer;

        multiPlexer = new InputMultiplexer();
        multiPlexer.addProcessor(stage);
        multiPlexer.addProcessor(stage1);
        multiPlexer.addProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                lastTouchX = screenX;
                lastTouchY = screenY;
                isDragging = true;
                return true;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                if(isDragging){
                    float deltaX = lastTouchX - screenX;
                    float deltaY = screenY - lastTouchY;

                    float newX = stage.getCamera().position.x + deltaX;
                    float newY = stage.getCamera().position.y + deltaY;

                    stage.getCamera().position.set(newX, newY, 0);
                    stage1.getCamera().position.set(newX, newY, 0);

                    lastTouchX = screenX;
                    lastTouchY = screenY;

                }
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                isDragging = false;
                return true;
            }
        });

        Gdx.input.setInputProcessor(multiPlexer);

    }

    @Override
    public void render(float v) {

        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            stage.getCamera().position.y += 2;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            stage.getCamera().position.y -= 2;

        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            stage.getCamera().position.x -= 2;

        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            stage.getCamera().position.x += 2;

        }

        if(stage.getCamera().position.x < 960/2) {
            stage.getCamera().position.x = 960/2;
        }
        if(stage.getCamera().position.x > 1080- 960/2) {
            stage.getCamera().position.x = 1080 - 960/2;
        }
        if(stage.getCamera().position.y < 540/2) {
            stage.getCamera().position.y = 540/2;
        }
        if(stage.getCamera().position.y > 540 - 540/2) {
            stage.getCamera().position.y = 540 - 540/2;
        }

        if(stage1.getCamera().position.y < 960/2) {
            stage1.getCamera().position.y = 960/2;
        }
        if(stage1.getCamera().position.y > 960 - 960/2) {
            stage1.getCamera().position.y = 960 - 960/2;
        }

        if(Gdx.input.isTouched()) {
            System.out.println(Gdx.input.getX() + " " + (540 - Gdx.input.getY()));
        }

        stage.act();
        stage.draw();
        stage1.act();
        stage1.draw();

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
        music.stop();

    }

    @Override
    public void dispose() {

    }
}
