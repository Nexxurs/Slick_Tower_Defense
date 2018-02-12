package Creatures;

import Map.Field.Path;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import util.MapUtil;

public class Dot extends AbstractCreature {

    Shape shape;

    public Dot(int fPosX, int fPosY, Path startPath) {
        super(startPath, 10);
        Vector2f posVec = MapUtil.fieldPosToVectorCenter(fPosX, fPosY);
        shape = new Circle(posVec.x, posVec.y, 10);
    }

    public Dot(Path startPath) {
        this(startPath.getFPosX(), startPath.getFPosY(), startPath);
    }

    protected float getMovespeed() {
        return 10;
    }

    @Override
    public float getLoot() {
        return 10;
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    public void drawMe(Graphics graphics) {
        if(canDespawn()) return;

        graphics.setColor(Color.red);
        graphics.draw(shape);
        graphics.fill(shape);
    }
}
