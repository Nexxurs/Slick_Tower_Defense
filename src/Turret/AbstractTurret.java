package Turret;

import Creatures.AbstractCreature;
import interfaces.Drawable;
import interfaces.Updateable;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

import java.util.List;

public abstract class AbstractTurret implements Drawable, Updateable {
    protected List<AbstractCreature> creaturesInRange(){
        return null;
        //todo
    }

    public void drawMe(Graphics graphics) {
        graphics.setColor(new Color(211,236,214,75));
        graphics.draw(getRange());
    }

    protected abstract Shape getShape();
    protected abstract Shape getRange();
}
