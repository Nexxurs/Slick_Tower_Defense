package SideElement;

import Button.AbstractButton;
import Singletons.Global;
import Turret.AbstractTurret;
import Turret.RectangleTurret;
import interfaces.Drawable;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.LinkedList;
import java.util.List;

public class Footer implements Drawable {

    private int width, height;
    private Shape background;
    private List<TurretPositionWrapper> turrets;

    private Global global = Global.getInstance();

    public Footer(int width, int height, int offsetHeight) {
        float spacer = height*0.1f;
        this.width = width;
        this.height = height;

        background = new Rectangle(0, offsetHeight, width, height);

        turrets = new LinkedList<>();

        AbstractTurret turret = new RectangleTurret(0,0);
        TurretPositionWrapper wrapper = new TurretPositionWrapper(turret, spacer, offsetHeight+spacer);

        turrets.add(wrapper);
    }

    @Override
    public void drawMe(Graphics graphics) {
        graphics.setColor(new Color(145,107,96));
        graphics.fill(background);

        for(TurretPositionWrapper wrapper : turrets){
            wrapper.drawMe(graphics);
        }
    }
}
