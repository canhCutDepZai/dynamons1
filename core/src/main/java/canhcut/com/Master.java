package canhcut.com;

import canhcut.com.screens.StartScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Master extends Game {
    public OrthographicCamera camera;
    public SpriteBatch batch;
    public BitmapFont font;


    @Override
    public void create() {

        batch = new SpriteBatch();
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters.size = 48;
        fontParameters.color = Color.WHITE;
        font = fontGenerator.generateFont(fontParameters);
        fontGenerator.dispose();

        camera = new OrthographicCamera();
        camera.setToOrtho( false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
        setScreen( new StartScreen(this));


    }

    @Override
    public void render() {
        super.render();

    }

}
