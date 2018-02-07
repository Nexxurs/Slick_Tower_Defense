package Turret.Projectile;

import Creatures.AbstractCreature;
import interfaces.Drawable;
import interfaces.Updateable;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;

public abstract class AbstractProjectile implements Drawable, Updateable {

    protected boolean despawn;
    protected AbstractCreature target;
    protected abstract float getMovespeed();
    protected abstract float getDMG();

    public AbstractProjectile(AbstractCreature target){
        this.target = target;
        despawn = false;
    }

    public abstract Shape getShape();

    public void update(int delta) {
        if(target.canDespawn()) despawn = true;
        if(despawn) return;

        Vector2f vector = new Vector2f(target.getShape().getCenterX() - getShape().getCenterX(), target.getShape().getCenterY() - getShape().getCenterY());
        vector = vector.getNormal();

        //ms*100/delta
        vector = vector.scale(getMovespeed()*delta/100);
        getShape().setLocation(getShape().getLocation().add(vector));

        if(getShape().intersects(target.getShape())){
            onHit(target);
        }
    }

    /**
     * Hook Method on collision with Creature
     * @return True, if Projectile disappears, else False
     */
    public boolean onHit(AbstractCreature creature){
        creature.handleDMG(getDMG());
        despawn = true;
        return true;
    }

    public boolean canDespawn(){
        return despawn;
    }

}
