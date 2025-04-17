package canhcut.com.screens;

import canhcut.com.characters.BaseActor;
import canhcut.com.characters.BaseActorAnimation;
import canhcut.com.characters.Character;
import canhcut.com.Master;
import canhcut.com.PokemonNames;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

import static canhcut.com.screens.BattleScreen.characters;

public class PokemonsDisplay implements Screen {
    Master game;
    Stage stage;
    BaseActorAnimation keTrungBay;
    BaseActor displayBackground;
    float lastX;
    boolean isDragging = false;

    public static Character notHide;
    static Character nextNotHide;
    static Character previousNotHide;
    float deltaX = 0;
    float speed;

    PokemonsDisplay(Master _game) {
        this.game = _game;
        stage = new Stage();

        displayBackground = new BaseActor(new Texture("displayBackground.jpg"), 0, 0);
        stage.addActor(displayBackground);
        displayBackground.toBack();

        keTrungBay = new BaseActorAnimation(new Texture("spritesheet.png"), 0, 0, stage, 1, 3);
        keTrungBay.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        keTrungBay.animation.setFrameDuration(0.3f);

        Character mewtwo = new Character(new Texture("mewtwo.png"), PokemonNames.MEWTWO, stage, 5, 25, Gdx.graphics.getWidth() / 2, 245, 100, 25, 12, 0);
        characters.add(mewtwo);
        Character pikachu = new Character(new Texture("pikachu.png"), PokemonNames.PIKACHU, stage, 3, 38, 0, 0245, 50, 12, 10, 0);
        characters.add(pikachu);
        Character dragonite = new Character(new Texture("dragonite.png"), PokemonNames.DRAGONITE, stage, 6, 17, 0, 0245, 150, 20, 9, 0);
        characters.add(dragonite);


        for (int i = 1; i < characters.size; i++) {
            characters.get(i).remove();
        }

        notHide = characters.get(0);
        notHide.setPosition(Gdx.graphics.getWidth() / 2 - characters.get(0).getWidth() / 2 - 50, 245);


        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;

        TextButton start = new TextButton("Go to Bigmap !!", style);
        start.setPosition(Gdx.graphics.getWidth() / 2 - start.getWidth() / 2, Gdx.graphics.getHeight() / 6 - start.getHeight() / 2);
        start.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new BigMapScreen(game));
            }
        });

        TextButton show = new TextButton("Pockedex Show !!", style);
        show.setPosition(Gdx.graphics.getWidth() / 2 - show.getWidth() / 2, Gdx.graphics.getHeight() / 4);
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

        InputMultiplexer multiPlexer;

        multiPlexer = new InputMultiplexer();
        multiPlexer.addProcessor(stage);
        multiPlexer.addProcessor(new InputAdapter() {
                                     @Override
                                     public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                                         if (!isDragging) {
                                             lastX = screenX;
                                             isDragging = true;
                                         }
                                         return true;
                                     }

                                     @Override
                                     public boolean touchDragged(int screenX, int screenY, int pointer) {
                                         return true;
                                     }

                                     @Override
                                     public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                                         deltaX = screenX - lastX;
                                         isDragging = false;
                                         if (Math.abs(deltaX) > 100 && deltaX < 0) {
                                             int i = characters.indexOf(notHide, true);
                                             if (i < characters.size - 1) {
                                                 notHide.addAction(Actions.fadeOut(0.5f));
                                                 notHide.addAction(Actions.sequence(
                                                     Actions.moveBy(-240, 0, 0.5f),
                                                     Actions.removeActor()
                                                 ));
                                                 nextNotHide = characters.get(i + 1);
                                                 stage.addActor(nextNotHide);
                                                 nextNotHide.setColor(1, 1, 1, 0);
                                                 nextNotHide.setPosition(Gdx.graphics.getWidth() * 3 / 4, 245);
                                                 nextNotHide.addAction(Actions.fadeIn(0.5f));
                                                 nextNotHide.addAction(Actions.sequence(
                                                     Actions.moveTo(Gdx.graphics.getWidth() / 2 - nextNotHide.getWidth() / 2 - 50, 245, 0.5f),
                                                     Actions.run(() -> notHide = nextNotHide)
                                                 ));
                                             }
                                         } else if (Math.abs(deltaX) > 100 && deltaX > 0) {
                                             int i = characters.indexOf(notHide, true);
                                             if (i > 0) {
                                                 notHide.addAction(Actions.fadeOut(0.5f));
                                                 notHide.addAction(Actions.sequence(
                                                     Actions.moveBy(480, 0, 0.5f),
                                                     Actions.removeActor()
                                                 ));
                                                 previousNotHide = characters.get(i - 1);
                                                 stage.addActor(previousNotHide);
                                                 previousNotHide.setPosition(Gdx.graphics.getWidth() / 4, 245);
                                                 previousNotHide.addAction(Actions.fadeIn(0.5f));
                                                 previousNotHide.addAction(Actions.sequence(
                                                     Actions.moveTo(Gdx.graphics.getWidth() / 2 - previousNotHide.getWidth() / 2 - 50, 245, 0.5f),
                                                     Actions.run(() -> notHide = previousNotHide)
                                                 ));
                                             }
                                         }
                                         deltaX = 0;
                                         return true;
                                     }
                                 }
        );

        Gdx.input.setInputProcessor(multiPlexer);
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
        stage.dispose();
    }

    @Override
    public void dispose() {

    }
}
