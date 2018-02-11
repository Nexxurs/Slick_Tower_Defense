package Turret.Projectile;

import Creatures.AbstractCreature;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import util.MapUtil;

public class SimpleSingletargetProjectile extends AbstractProjectile {
    private float dmg, movespeed;
    private Shape shape;

    public SimpleSingletargetProjectile(int fPosX, int fPosY, float dmg, float movespeed, AbstractCreature target){
        super(target);
        this.dmg = dmg;
        this.movespeed = movespeed;
        Vector2f posVec = MapUtil.fieldPosToVectorCenter(fPosX, fPosY);
        shape = new Circle(posVec.x,posVec.y,5);
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
