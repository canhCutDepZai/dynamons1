package canhcut.com.characters;

import canhcut.com.PokemonNames;
import canhcut.com.screens.BattleScreen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Avatar extends BaseActor {
    PokemonNames name;
    public Avatar(Texture texture, PokemonNames name) {
        super(texture, 0, 0);
        this.name = name;
        setSize(64,64);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setColor(Color.GRAY);
                for (Character c: BattleScreen.characterAway) {
                    if(c.name.equals(name)){
                        switch (name) {
                            case MEWTWO -> {
                                c.setAnimation(new Texture("mewtwo/mewtwo_back.png"), 1, 125);
                            }
                            case PIKACHU -> {
                                c.setAnimation(new Texture("pikachu/pikachu_back.png"), 1, 113);
                            }
                            case DRAGONITE -> {
                            c.setAnimation(new Texture("dragonite/dragonite_back.png"), 1, 102)
                            ;}
                            case LAPRAS -> {
                                c.setAnimation(new Texture("lapras/lapras_back.png"), 1, 65);
                            }
                        }
                        c.setPosition(25, 62);
                        getStage().addActor(c);

                    } else {
                        c.avatar.setColor(1,1,1,1);
                        c.remove();
                    }
                }
            }
        });
    }
}
