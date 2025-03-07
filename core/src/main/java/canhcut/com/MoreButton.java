package canhcut.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MoreButton extends BaseActor{
    static boolean isAddedClicked = false;
    static MoreButton back, escape;
    static BgAlpha bgAlpha;
    static boolean isBackClicked = false;
    static boolean isEscapeClicked = false;




    MoreButton(Texture texture, float x, float y,Stage s, int type, Master game){
    super(texture,x,y);
    if(type==0){
        this.texture.setRegion(183, 0, 61, 70);
    } else if(type==1){
        this.texture.setRegion(0, 0, 61, 70);
    }else if(type==2){
        this.texture.setRegion(61, 0, 61, 70);
    }
    s.addActor(this);


        setSize(61, 70);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                if (!isAddedClicked||!isBackClicked||!isEscapeClicked) {

                    if(type==0){
                        isAddedClicked = true;
                        isBackClicked = false;
                        isEscapeClicked = false;
                        if(bgAlpha != null){
                            s.addActor(bgAlpha);
                        }else {
                            bgAlpha = new BgAlpha(new Texture("alpha.png"), 0, 0, s);
                        }
                        if(back != null){
                            s.addActor(back);
                        }else{
                            back = new MoreButton(texture, x + 183+61, 0, s,  1, game);
                        }
                        if(escape != null){
                            s.addActor(escape);
                        }else {
                            escape = new MoreButton(texture, x + 183+61+61, 0, s, 2, game);
                        }

                    }else if(type==1){
                        isBackClicked = false;
                        isBackClicked = true;
                        back.remove();
                        escape.remove();
                        bgAlpha.remove();
                    }
                    else if(type==2){
                        isBackClicked = false;
                        isBackClicked = true;
                        game.setScreen(new BigMapScreen(game));
                    }
                }
            }
        });
    }
}
