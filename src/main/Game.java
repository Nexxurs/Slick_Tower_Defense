package main;

import Map.AbstractMap;
import Map.SimpleMap;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {
    AbstractMap map;

    public Game(){
        super("Turret Defense");
    }



    public void init(GameContainer gameContainer) throws SlickException {
        Global global = Global.getInstance();
        map = new SimpleMap(gameContainer.getWidth(), gameContainer.getHeight());
        global.setCurrentMap(map);
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {
        map.update(i);
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        map.drawMe(graphics);
    }
}
