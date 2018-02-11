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
    public static final int HEADER_HEIGHT = 50;

    public static void main(String[] args) throws SlickException {
        BasicGame game = new Game();
        AppGameContainer container = new AppGameContainer(game);
        container.setDisplayMode(NUM_FIELDS_WIDTH * SIDELENGTH_FIELD,
                NUM_FIELDS_HEIGHT * SIDELENGTH_FIELD + HEADER_HEIGHT,
                false);
        container.setVSync(true);
        container.setShowFPS(false);
        container.start();

    }
}
