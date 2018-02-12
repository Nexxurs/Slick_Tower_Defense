package Singletons;

import Map.AbstractMap;
import SideElement.Header;
import main.Main;
import org.newdawn.slick.GameContainer;

public class Global {
    private static Global ourInstance = new Global();

    public final int DEFAULT_SPEED_MULTIPLICATOR = 1;

    public static Global getInstance() {
        return ourInstance;
    }
    private AbstractMap map;
    private Header header;
    private GameContainer gameContainer;
    private int speedMultiplicator;

    private Global() {
        speedMultiplicator = DEFAULT_SPEED_MULTIPLICATOR;
    }

    public int getFieldSideLenght() {
        return Main.SIDELENGTH_FIELD;
    }

    public int getNumFieldsHeight() {
        return Main.NUM_FIELDS_HEIGHT;
    }

    public int getNumFieldsWidth() {
        return Main.NUM_FIELDS_WIDTH;
    }

    public AbstractMap getCurrentMap() {
        return map;
    }

    public void setCurrentMap(AbstractMap map) {
        this.map = map;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public GameContainer getGameContainer() {
        return gameContainer;
    }

    public void setGameContainer(GameContainer gameContainer) {
        this.gameContainer = gameContainer;
    }

    public int getSpeedMultiplicator() {
        return speedMultiplicator;
    }

    public void setSpeedMultiplicator(int speedMultiplicator) {
        this.speedMultiplicator = speedMultiplicator;
    }
}
