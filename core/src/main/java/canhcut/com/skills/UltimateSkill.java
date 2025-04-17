package canhcut.com.skills;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class UltimateSkill extends Actor {
    TextureRegion texture;
    boolean isActive = true;
    float startX, startY;

    public UltimateSkill(Texture texture, float x, float y) {
        startX = x;
        startY = y;
        this.texture = new TextureRegion(texture);
        setSize(96, 96);
        setPosition(x, y - getHeight());


        setColor(1,1,1,0f);
        addAction(Actions.moveBy(0, getHeight(), 1f));
        addAction(Actions.fadeIn(2));

       addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y) {
               if(isActive){
                   isActive = false;
                   addAction(Actions.sequence(
                       Actions.repeat(20, Actions.sequence(
                           Actions.moveBy(-5, 0, 0.02f),
                           Actions.moveBy(5, 0, 0.02f)
                       )),
                       Actions.moveBy(0, 50, 1f),
                       Actions.run(()->{
                           setPosition(startX, startY);
                       }),

                       Actions.repeat(10, Actions.sequence(
                               Actions.delay(MathUtils.random(0f, 0.5f)),
                               Actions.run(() -> {
                                       Fire fire = new Fire(new Texture("empty/fire.png"), 0, 0, getStage());
                                   }
                               )
                           )
                       )

                   ));
                   addAction(Actions.sequence(
                       Actions.fadeOut(2.4f),
                       Actions.fadeIn(4f),
                       Actions.run(()->{
                           isActive = true;
                       })
                   ));
               }




           }
       });

    }

    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a * parentAlpha);
        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(1, 1, 1, 1);
    }

}
