package Singletons;

import Map.AbstractMap;
import SideElement.Header;
import main.Main;

public class Global {
    private static Global ourInstance = new Global();

    public static Global getInstance() {
        return ourInstance;
    }
    private AbstractMap map;
    private Header header;

    private Global() {}

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
}
