package Turret;

import Creatures.AbstractCreature;
import Map.AbstractMap;
import Turret.Projectile.AbstractProjectile;
import interfaces.Drawable;
import interfaces.Updateable;
import Singletons.Global;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import util.MouseUtil;

import java.util.List;

public abstract class AbstractTurret implements Drawable, Updateable {

    private int cdTimer = 0;
    private Global global = Global.getInstance();

    public void drawMe(Graphics graphics) {
        Shape mouse = MouseUtil.createMouseShape();
        if(mouse.intersects(getShape())){
            graphics.setColor(Color.yellow);
            graphics.draw(getShape());
        }
        graphics.setColor(new Color(211,236,214,75));
        graphics.draw(getRange());

        graphics.setColor(getColor());
        graphics.fill(getShape());
    }

    public abstract void setFPos(int fPosX, int fPosY);

    public abstract Shape getShape();
    public abstract Shape getRange();
    public abstract Color getColor();
    protected abstract AbstractProjectile createProjectile(AbstractCreature target);
    protected abstract int getCooldownInMillis();

    public abstract AbstractTurret copy();

    @Override
    public void update(int delta) {
        cdTimer += delta*global.getSpeedMultiplicator();
        if(cdTimer > getCooldownInMillis()){
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
