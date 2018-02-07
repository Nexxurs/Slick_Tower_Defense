package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.SlickException;

/**
 * VM Option to run on windows:
 *  -Djava.library.path=libs/
 */
public class Main {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    public static void main(String[] args) throws SlickException {
        BasicGame game = new Game();
        AppGameContainer container = new AppGameContainer(game);
        container.setDisplayMode(WIDTH, HEIGHT, false);
        container.setVSync(true);
        container.start();


    }
}
