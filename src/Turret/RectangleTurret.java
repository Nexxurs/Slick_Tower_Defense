package Turret;

import Creatures.AbstractCreature;
import Turret.Projectile.AbstractProjectile;
import Turret.Projectile.SimpleSingletargetProjectile;
import Singletons.Global;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import util.MapUtil;

public class RectangleTurret extends AbstractTurret {

    private Shape shape, range;
    private int fPosX, fPosY;

    public RectangleTurret(int fPosX, int fPosY){

        this.fPosX = fPosX;
        this.fPosY = fPosY;

        Global global = Global.getInstance();


        float width = global.getFieldSideLenght()*0.6f;
        float height = global.getFieldSideLenght()*0.9f;

        Vector2f centerVec = MapUtil.fieldPosToVectorCenter(fPosX, fPosY);
        this.shape = new Rectangle(0,0, width, height);
        this.shape.setCenterX(centerVec.x);
        this.shape.setCenterY(centerVec.y);

        this.range = new Circle(centerVec.x, centerVec.y, 100);
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
        return new SimpleSingletargetProjectile(fPosX, fPosY, 5, 3, target);
    }

    @Override
    protected int getCooldownInMillis() {
        return 1000;
    }
}
