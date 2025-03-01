package canhcut.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Skills extends Actor{
    TextureRegion texture;

    Skills(Texture texture, float x, float y, int lv){
        this.texture = new TextureRegion(texture);
        setPosition(x, y);
        setSize(128, 128);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(lv ==1) {
                    addAction(Actions.sequence(
                        Actions.repeat(20, Actions.sequence(
                            Actions.moveBy(-5, 0, 0.02f),
                            Actions.moveBy(5, 0, 0.02f)
                        )),
                        Actions.moveBy(0, 50, 1f),
                        Actions.run(()->{
                            boolean b = BattleScreen.skillActive == true;
                        }),
                        Actions.repeat(10, Actions.sequence(
                                Actions.delay(MathUtils.random(0f, 0.5f)),
                                Actions.run(() -> {
                                        if (lv == 1) {
                                            Fire fire = new Fire(new Texture("empty/fire.png"), 0, 0, getStage());
                                        }
                                    }
                                )
                            )
                        ),
                        Actions.removeActor()
                    ));
                } else if(lv ==2) {
                    addAction(Actions.sequence(
                        Actions.repeat(20, Actions.sequence(
                            Actions.moveBy(-5, 0, 0.02f),
                            Actions.moveBy(5, 0, 0.02f)
                        )),
                        Actions.moveBy(0, 50, 1f),
                        Actions.run(()-> {
                            if (lv == 2) {
                                Smoke smoke = new Smoke(new Texture("empty/smoke.png"), 0, 0, getStage());
                            }
                        }),
                            Actions.removeActor()
                    ));

                }
                addAction(Actions.fadeOut(2f)); // làm mờ
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha)  {
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a*parentAlpha);
        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(1,1,1,1);
    }
  }
