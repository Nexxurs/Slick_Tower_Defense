package Map.Field;

import Singletons.Global;
import Turret.AbstractTurret;
import org.newdawn.slick.Color;
import util.MapUtil;

public class GrassField extends ClickableField {

    public GrassField(int fPosX, int fPosY){
        super(fPosX, fPosY);
    }

    @Override
    public void onClick() {

        Global global = Global.getInstance();
        if (global.getTurretOfMouse() != null){
            AbstractTurret turret = global.getTurretOfMouse().copyTurret();

            turret.setFPos(fPosX, fPosY);

            global.getCurrentMap().registerTurret(turret);

            global.getTurretOfMouse().followMouse(false);
            global.setTurretOfMouse(null);
        }

    }

    @Override
    protected Color getFillColor() {
        return new Color(0,140,0);
    }
}
