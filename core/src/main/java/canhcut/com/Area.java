package canhcut.com;

import canhcut.com.characters.BaseActor;
import canhcut.com.screens.BattleScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Area extends BaseActor {

    int level = 1;
    Master game;
    public Area(Texture texture, float x, float y, Stage s, int level, Master game){
        super(texture, x, y);

        this.level = level;
        this.game = game;
        s.addActor(this);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("clicked,sjdbnakjshkfvcndfsn");
                if (level == 1) {
                    game.setScreen(new BattleScreen(game));
                }

//                } else if(level == 2){
//
//                }
//
//            }
            }
        });
    }
}


