package Creatures;

import Map.Field.Path;
import Singletons.Bank;
import interfaces.Drawable;
import interfaces.Updateable;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import util.ShapeUtil;

public abstract class AbstractCreature implements Drawable, Updateable {

    private float health;
    protected boolean despawn;
    private Path nextPath;

    public AbstractCreature(Path startPath, float health){
        this.health = health;
        this.despawn = false;
        nextPath = startPath;
    }

    protected abstract float getMovespeed();

    public void handleDMG(float dmg){
        health -= dmg;
        if(health <= 0){
            Bank.getInstance().addMoney(getLoot());
            despawn = true;
        }
    }

    public abstract Shape getShape();

    public abstract float getLoot();

    public void update(int delta) {
        if(despawn) return;
        if(health <=0){
            despawn = true;
        }

        float startDistance = ShapeUtil.getDistanceBetweenShapeCenters(getShape(), nextPath.getShape());
        Vector2f startLocation = new Vector2f(getShape().getLocation());
        ShapeUtil.moveShapeToCenter(getShape(), nextPath.getShape(), getMovespeed(), delta);

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
}
