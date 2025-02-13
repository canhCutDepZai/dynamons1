package canhcut.com;

import com.badlogic.gdx.*;
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

    float lastTouchX;
    float lastTouchY;
    boolean isDragging = false ;



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

        bigmapBackground = new BaseActor(new Texture("bigmap1.PNG"), 0,0);
        bigmapBackground.setSize(1582, 1136);
        stage.addActor(bigmapBackground);

        stage.addActor(begin);

        InputMultiplexer multiPlexer;

        multiPlexer = new InputMultiplexer();
        multiPlexer.addProcessor(stage);
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

        if(stage.getCamera().position.x < 540/2) {
            stage.getCamera().position.x = 540/2;
        }
        if(stage.getCamera().position.x > 1582 - 540/2) {
            stage.getCamera().position.x = 1582 - 540/2;
        }
        if(stage.getCamera().position.y < 960/2) {
            stage.getCamera().position.y = 960/2;
        }
        if(stage.getCamera().position.y > 1136 - 960/2) {
            stage.getCamera().position.y = 1136 - 960/2;
        }


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
