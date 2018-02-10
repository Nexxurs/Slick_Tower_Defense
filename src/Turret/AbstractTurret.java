package Turret;

import Creatures.AbstractCreature;
import Map.AbstractMap;
import Turret.Projectile.AbstractProjectile;
import interfaces.Drawable;
import interfaces.Updateable;
import main.Global;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

import java.util.List;

public abstract class AbstractTurret implements Drawable, Updateable {

    int cdTimer = 0;

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
    protected abstract AbstractProjectile createProjectile(AbstractCreature target);
    protected abstract int getCooldownInMillis();

    @Override
    public void update(int delta) {
        cdTimer += delta;
        int cd = getCooldownInMillis();
        if(cdTimer > cd){
            Global global = Global.getInstance();
            AbstractMap map = global.getCurrentMap();
            List<AbstractCreature> creatures = map.getAllCurrentCreatures();

            AbstractCreature nearestCreature = null;
            float nearestDistance = 0;

            for(AbstractCreature creature : creatures){

                if(creature.getShape().intersects(getRange())){
                    if(nearestCreature == null){
                        nearestCreature = creature;
                        nearestDistance = creature.getShape().getLocation().distance(getShape().getLocation());
                    } else {
                        float distance = creature.getShape().getLocation().distance(getShape().getLocation());
                        if(distance < nearestDistance){
                            nearestCreature = creature;
                            nearestDistance = distance;
                        }
                    }
                }
            }
            if(nearestCreature != null){
                cdTimer = 0;
                AbstractProjectile proj = createProjectile(nearestCreature);
                map.registerProjectile(proj);
            }
        }
    }
}
