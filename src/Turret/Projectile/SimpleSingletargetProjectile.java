package Turret.Projectile;

import Creatures.AbstractCreature;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class SimpleSingletargetProjectile extends AbstractProjectile {
    private float dmg, movespeed;
    private Shape shape;

    public SimpleSingletargetProjectile(float posX, float posY, float dmg, float movespeed, AbstractCreature target){
        super(target);
        this.dmg = dmg;
        this.movespeed = movespeed;
        shape = new Circle(posX,posY,5);
    }

    protected float getMovespeed() {
        return movespeed;
    }

    protected float getDMG() {
        return dmg;
    }

    public Shape getShape() {
        return shape;
    }

    public void drawMe(Graphics graphics) {
        graphics.setColor(Color.cyan);
        graphics.fill(shape);
    }
}
