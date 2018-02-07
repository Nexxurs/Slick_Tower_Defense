package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.SlickException;

/**
 * VM Option to run on windows:
 *  -Djava.library.path=libs/
 */
public class Main {

    public static final int NUM_FIELDS_WIDTH = 20;
    public static final int NUM_FIELDS_HEIGHT = 15;
    public static final int SIDELENGTH_FIELD = 30;

    public static void main(String[] args) throws SlickException {
        Global global = Global.getInstance();

        global.setFieldSideLenght(SIDELENGTH_FIELD);
        global.setNumFieldsHeight(NUM_FIELDS_HEIGHT);
        global.setNumFieldsWidth(NUM_FIELDS_WIDTH);

        BasicGame game = new Game();
        AppGameContainer container = new AppGameContainer(game);
        container.setDisplayMode(NUM_FIELDS_WIDTH * SIDELENGTH_FIELD, NUM_FIELDS_HEIGHT * SIDELENGTH_FIELD,
                false);
        container.setVSync(true);
        container.start();


    }
}
