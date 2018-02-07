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
        creatures = new LinkedList<AbstractCreature>();
        turrets = new LinkedList<AbstractTurret>();
        projectiles = new LinkedList<AbstractProjectile>();
        //todo
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

    public void update(int delta) {
        for(AbstractProjectile projectile : projectiles){
            projectile.update(delta);
        }
        projectiles.removeIf(proj -> proj.canDespawn());
    }

    List<AbstractCreature> getAllCurrentCreatures(){
        return new LinkedList<AbstractCreature>(creatures);
    }
}
