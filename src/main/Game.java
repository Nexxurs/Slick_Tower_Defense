package main;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Game extends BasicGame {

    Rectangle rect;

    public Game(){
        super("Turret Defense");
    }



    public void init(GameContainer gameContainer) throws SlickException {
        rect = new Rectangle(0,0,20,20);
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {
        float newX = rect.getX()+5;
        newX = newX % gameContainer.getWidth();
        rect.setX(newX);

        float newY = rect.getY()+5;
        newY = newY % gameContainer.getHeight();
        rect.setY(newY);
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.fill(rect);
        graphics.draw(rect);

    }
}
