package SideElement;

import Creatures.AbstractCreature;
import Singletons.Global;
import Turret.AbstractTurret;
import Turret.Projectile.AbstractProjectile;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import util.MouseUtil;

public class TurretPositionWrapper extends AbstractTurret {

    private AbstractTurret turret;
    private boolean followMouse = false;
    private Vector2f defaultLocation;
    private Global global;

    public TurretPositionWrapper(AbstractTurret turret, float posX, float posY){
        this.turret = turret;
        defaultLocation = new Vector2f(posX, posY);
        turret.getShape().setLocation(defaultLocation);

        global = Global.getInstance();
    }

    public AbstractTurret getTurret() {
        return turret;
    }

    public void followMouse(boolean value){
        if(followMouse && !value){
            turret.getShape().setLocation(defaultLocation);
        }

        if(value && global.getTurretOfMouse() != null){
            global.getTurretOfMouse().followMouse(false);
        }

        if(value){
            global.setTurretOfMouse(this);
            System.out.println("New Follow mouse "+value);
        }

        this.followMouse = value;

    }

    @Override
    public Shape getShape() {
        return turret.getShape();
    }

    @Override
    public Shape getRange() {
        return turret.getRange();
    }

    @Override
    public Color getColor() {
        return turret.getColor();
    }

    @Override
    protected AbstractProjectile createProjectile(AbstractCreature target) {
        return null;
    }

    @Override
    protected int getCooldownInMillis() {
        return 0;
    }

    public AbstractTurret copyTurret(){
        return turret.copy();
    }

    @Override
    public void drawMe(Graphics graphics) {
        Color color = new Color(getColor());

        if(!followMouse){
            Shape mouse = MouseUtil.createMouseShape();
            if(mouse.intersects(getShape()) && MouseUtil.isPrimaryMouseButtonClicked()){
                System.out.println("intersec");
                followMouse(true);
            }
        }


        if(followMouse){
            color.a = 0.5f;

            Input input = global.getGameContainer().getInput();
            int posX = input.getMouseX();
            int posY = input.getMouseY();
            turret.getShape().setCenterX(posX);
            turret.getShape().setCenterY(posY);

            if(MouseUtil.isPrimaryMouseButtonClicked()){
                //todo hier weiter
                System.out.println("Sit down");
                followMouse(false);
            }
        }



        graphics.setColor(color);
        graphics.fill(turret.getShape());
    }

    @Override
    public AbstractTurret copy() {
        return null;
        //todo
    }

    @Override
    public void update(int delta) {
        //do nothing on update
    }
}
