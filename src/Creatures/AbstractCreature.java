package Creatures;

import Map.Field.Path;
import interfaces.Drawable;
import interfaces.Updateable;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import util.ShapeUtil;

public abstract class AbstractCreature implements Drawable, Updateable {

    private float health;
    protected Shape shape;
    protected boolean despawn;
    private Path nextPath;

    public AbstractCreature(Shape shape, Path startPath, float health){
        this.shape = shape;
        this.health = health;
        this.despawn = false;
        nextPath = startPath;
    }

    protected abstract float getMovespeed();

    public void handleDMG(float dmg){
        health -= dmg;
        if(health <= 0){
            despawn = true;
        }
    }

    public Shape getShape(){
        return shape;
    }

    public void update(int delta) {
        if(despawn) return;
        if(health <=0){
            despawn = true;
        }

        float startDistance = ShapeUtil.getDistanceBetweenShapeCenters(shape, nextPath.getShape());
        Vector2f startLocation = new Vector2f(getShape().getLocation());
        ShapeUtil.moveShapeToCenter(shape, nextPath.getShape(), getMovespeed(), delta);

        Vector2f endLocation = new Vector2f(getShape().getLocation());

        float moveDistance = startLocation.distance(endLocation);

        if(startDistance <= moveDistance){
            nextPath = nextPath.getNext();
            if(nextPath == null){
                despawn = true;
            }
        }
    }

    public boolean canDespawn() {
        return despawn;
    }

    private static float pythagoras(float a, float b){
        return (float) Math.abs(Math.sqrt((a*a)+(b*b)));
    }

    private static float[] getMovementVector(Shape me, Shape destination){
        float destX = destination.getCenterX() - me.getCenterX();
        float destY = destination.getCenterY() - me.getCenterY();

        if(destX < 0) destX = -1;
        else if(destX > 0) destX = 1;

        if(destY < 0) destY = -1;
        else if(destY > 0) destY = 1;

        return new float[]{destX, destY};
    }
}
