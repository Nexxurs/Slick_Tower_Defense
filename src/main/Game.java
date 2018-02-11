package main;

import Map.AbstractMap;
import Map.SimpleMap;
import SideElement.Header;
import Singletons.Global;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {
    AbstractMap map;
    Header header;

    public Game(){
        super("Turret Defense");
    }



    public void init(GameContainer gameContainer) throws SlickException {
        Global global = Global.getInstance();

        header = new Header(gameContainer.getWidth(), Main.HEADER_HEIGHT);
        map = new SimpleMap(gameContainer.getWidth(), gameContainer.getHeight() - header.getHeight());
        global.setCurrentMap(map);
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {
        map.update(i);
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        header.drawMe(graphics);
        map.drawMe(graphics);
    }
}
