package Creatures;

import Map.Field.Path;
import main.Global;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class Dot extends AbstractCreature {

    public Dot(int posX, int posY, Path startPath) {
        super(createShape(posX, posY),startPath, 10);
    }

    protected float getMovespeed() {
        return 1;
    }

    public void drawMe(Graphics graphics) {
        if(canDespawn()) return;

        graphics.setColor(Color.red);
        graphics.draw(shape);
        graphics.fill(shape);
    }

    //Super must be the first call in constructor -.-
    private static Shape createShape(int posX, int posY){
        Global global = Global.getInstance();
        int offset = global.getFieldSideLenght()/2;
        return new Circle(posX+offset,posY+offset,10);
    }
}
