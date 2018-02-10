package Turret;

import Creatures.AbstractCreature;
import Turret.Projectile.AbstractProjectile;
import Turret.Projectile.SimpleSingletargetProjectile;
import main.Global;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class RectangleTurret extends AbstractTurret {

    private Shape shape, range;

    public RectangleTurret(float posX, float posY){
        Global global = Global.getInstance();


        float width = global.getFieldSideLenght()*0.6f;
        float height = global.getFieldSideLenght()*0.9f;

        float x = posX + ((global.getFieldSideLenght() - width)/2);
        float y = posY + ((global.getFieldSideLenght() - height)/2);



        this.shape = new Rectangle(x,y, width,height);
        this.range = new Circle(posX+(global.getFieldSideLenght()/2), posY+(global.getFieldSideLenght()/2), 100);
    }

    public RectangleTurret(Vector2f vec){
        this(vec.x, vec.y);
    }

    protected Shape getShape() {
        return shape;
    }

    protected Shape getRange() {
        return range;
    }

    public void drawMe(Graphics graphics) {
        super.drawMe(graphics);
        graphics.setColor(Color.blue);
        graphics.fill(shape);
    }

    @Override
    protected AbstractProjectile createProjectile(AbstractCreature target) {
        return new SimpleSingletargetProjectile(getShape().getCenterX(), getShape().getCenterY(), 5, 3, target);
    }

    @Override
    protected int getCooldownInMillis() {
        return 1000;
    }
}
