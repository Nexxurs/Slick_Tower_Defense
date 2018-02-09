package Map;

import Creatures.AbstractCreature;
import Turret.AbstractTurret;
import Turret.Projectile.AbstractProjectile;
import interfaces.Drawable;
import interfaces.Updateable;
import org.newdawn.slick.Graphics;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractMap implements Drawable, Updateable {

    protected int width, height;
    private List<AbstractCreature> creatures;
    private List<AbstractTurret> turrets;
    private List<AbstractProjectile> projectiles;

    public AbstractMap(int width, int height){
        this.width = width;
        this.height = height;
        creatures = new LinkedList<>();
        turrets = new LinkedList<>();
        projectiles = new LinkedList<>();
    }

    public void drawCreatures(Graphics graphics) {
        for(AbstractCreature creature : creatures){
            if(!creature.canDespawn())
                creature.drawMe(graphics);
        }
    }

    public void drawTurrets(Graphics graphics) {
        for(AbstractTurret turret : turrets){
           turret.drawMe(graphics);
        }
    }

    public void drawProjectiles(Graphics graphics) {
        for(AbstractProjectile projectile : projectiles){
            if(!projectile.canDespawn())
                projectile.drawMe(graphics);
        }
    }

    public void registerProjectile(AbstractProjectile projectile){
        projectiles.add(projectile);
    }

    public void registerTurret(AbstractTurret turret){
        turrets.add(turret);
    }

    public void registerCreature(AbstractCreature creature){
        creatures.add(creature);
    }

    /**
     * To override!
     * super(), then create new Objects (Creatures)
     * @param delta
     */
    public void update(int delta) {
        for(Updateable projectile : projectiles){
            projectile.update(delta);
        }
        projectiles.removeIf(AbstractProjectile::canDespawn);

        for(AbstractProjectile proj : projectiles){
            for(AbstractCreature creature : creatures){
                if(proj.getShape().intersects(creature.getShape())){
                    proj.onHit(creature);
                }
            }
        }


        for(Updateable creature : creatures){
            creature.update(delta);
        }
        creatures.removeIf(AbstractCreature::canDespawn);

        for(Updateable turret : turrets){
            turret.update(delta);
        }
    }

    /**
     * First draw your map, then super() to draw the Objects
     * @param graphics
     */
    @Override
    public void drawMe(Graphics graphics) {
        for(Drawable d : turrets){
            d.drawMe(graphics);
        }
        for(Drawable d : creatures){
            d.drawMe(graphics);
        }
        for(Drawable d : projectiles){
            d.drawMe(graphics);
        }

    }

    List<AbstractCreature> getAllCurrentCreatures(){
        return new LinkedList<AbstractCreature>(creatures);
    }
}
