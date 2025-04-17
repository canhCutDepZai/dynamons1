package canhcut.com.skills;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Skills extends Actor{
    TextureRegion texture;
    float startX;
    float startY;
    int lv;
    Texture texture1;

    public Skills(Texture texture, float x, float y, int lv) {
        this.texture = new TextureRegion(texture);
        setSize(96, 96);
        setPosition(x, y - getHeight());
        startX = x;
        startY = y;
        this.lv = lv;
        texture1 = texture;

        setColor(1,1,1,0f);
        addAction(Actions.moveBy(0, getHeight(), 1f));
        addAction(Actions.fadeIn(2));

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                if (lv == 1) {
//                    if(isActive) {
//                        addAction(Actions.sequence(
//                            Actions.repeat(20, Actions.sequence(
//                                Actions.moveBy(-5, 0, 0.02f),
//                                Actions.moveBy(5, 0, 0.02f)
//                            )),
//                            Actions.moveBy(0, 50, 1f),
//
//                            Actions.repeat(10, Actions.sequence(
//                                    Actions.delay(MathUtils.random(0f, 0.5f)),
//                                    Actions.run(() -> {
//                                            Fire fire = new Fire(new Texture("empty/fire.png"), 0, 0, getStage());
//                                        }
//                                    )
//                                )
//                            ),
//                            Actions.run(() -> {isActive = false;})
//                        ));
//                    }
//                    System.out.println("chưa đủ nộ!!");
//                } else
                if (lv == 2) {
                    addAction(Actions.sequence(
                        Actions.repeat(20, Actions.sequence(
                            Actions.moveBy(-5, 0, 0.02f),
                            Actions.moveBy(5, 0, 0.02f)
                        )),
                        Actions.moveBy(0, 50, 1f),
                        Actions.run(() -> {
                            Smoke smoke = new Smoke(new Texture("empty/smoke.png"), 0, 0, getStage());
                        }
                        )
                    ));
                }

                addAction(Actions.sequence(Actions.fadeOut(3f),
                        Actions.removeActor()
                    ));

                addAction(Actions.sequence(
                        Actions.delay(2f),
                        Actions.run(() -> {
                            getStage().addActor(new Skills(texture1, startX, startY, lv));
                        })
                    )
                );
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a * parentAlpha);
        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(1, 1, 1, 1);
    }
}
