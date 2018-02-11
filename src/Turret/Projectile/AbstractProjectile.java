package Turret.Projectile;

import Creatures.AbstractCreature;
import interfaces.Drawable;
import interfaces.Updateable;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import util.ShapeUtil;

public abstract class AbstractProjectile implements Drawable, Updateable {

    private boolean despawn;
    protected AbstractCreature target;
    protected abstract float getMovespeed();
    protected abstract float getDMG();

    public AbstractProjectile(AbstractCreature target){
        this.target = target;
        despawn = false;
    }

    public abstract Shape getShape();

    public void update(int delta) {
        if(canDespawn()) return;

        //ShapeUtil.moveShapeToCenter(getShape(), target.getShape(), getMovespeed(), delta);

        float startDistance = ShapeUtil.getDistanceBetweenShapeCenters(getShape(), target.getShape());
        Vector2f startLocation = new Vector2f(getShape().getLocation());
        ShapeUtil.moveShapeToCenter(getShape(), target.getShape(), getMovespeed(), delta);

        Vector2f endLocation = new Vector2f(getShape().getLocation());

        float moveDistance = startLocation.distance(endLocation);

        if(startDistance <= moveDistance){
            despawn = true;
        }
    }

    /**
     * Hook Method on collision with Creature
     * @return True, if Projectile disappears, else False
     */
    public boolean onHit(AbstractCreature creature){
        if(canDespawn()){
            return true;
        }
        creature.handleDMG(getDMG());
        shallDespawn();
        return true;
    }

    public boolean canDespawn(){
        return despawn;
    }

    public void shallDespawn(){
        despawn = true;
    }

}
