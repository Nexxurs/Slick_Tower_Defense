package main;

import Map.AbstractMap;
import Map.SimpleMap;
import SideElement.Header;
import Singletons.Global;
import org.newdawn.slick.*;

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
        global.setGameContainer(gameContainer);
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {
        map.update(i);
        header.update(i);
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        map.drawMe(graphics);
        header.drawMe(graphics);
    }
}
