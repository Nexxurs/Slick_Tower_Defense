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

    private Global global;

    public RectangleTurret(int fPosX, int fPosY){
        global = Global.getInstance();
        float width = global.getFieldSideLenght()*0.6f;
        float height = global.getFieldSideLenght()*0.9f;

        this.shape = new Rectangle(0,0, width, height);
        this.range = new Circle(0, 0, 100);

        setFPos(fPosX, fPosY);

    }

    @Override
    public Color getColor() {
        return Color.blue;
    }

    @Override
    public AbstractTurret copy() {
        RectangleTurret t = new RectangleTurret(fPosX,fPosY);
        return t;
    }

    @Override
    public void setFPos(int fPosX, int fPosY) {
        this.fPosX = fPosX;
        this.fPosY = fPosY;

        Vector2f centerVec = MapUtil.fieldPosToVectorCenter(fPosX, fPosY);

        this.shape.setCenterX(centerVec.x);
        this.shape.setCenterY(centerVec.y);

        this.range.setCenterX(centerVec.x);
        this.range.setCenterY(centerVec.y);
    }

    public Shape getShape() {
        return shape;
    }

    public Shape getRange() {
        return range;
    }


    @Override
    protected AbstractProjectile createProjectile(AbstractCreature target) {
        return new SimpleSingletargetProjectile(fPosX, fPosY, 5, 30, target);
    }

    @Override
    protected int getCooldownInMillis() {
        return 1000;
    }
}
