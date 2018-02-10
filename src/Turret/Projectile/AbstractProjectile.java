package Turret.Projectile;

import Creatures.AbstractCreature;
import interfaces.Drawable;
import interfaces.Updateable;
import org.newdawn.slick.geom.Shape;
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

        ShapeUtil.moveShapeToCenter(getShape(), target.getShape(), getMovespeed(), delta);
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
