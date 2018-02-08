package Map;

import Creatures.AbstractCreature;
import Creatures.Dot;
import Map.Field.AbstractField;
import Map.Field.Path;
import Turret.AbstractTurret;
import Turret.Projectile.SimpleSingletargetProjectile;
import Turret.RectangleTurret;
import main.Global;
import org.newdawn.slick.Graphics;

import java.util.List;

public class SimpleMap extends AbstractMap {
    //todo NEU

    AbstractField[][] fields;


    public SimpleMap(int w, int h){
        super(w,h);

        Global global = Global.getInstance();

        int numFieldsW = w/global.getFieldSideLenght();
        int numFieldsH = h/global.getFieldSideLenght();

        this.fields = new AbstractField[numFieldsW][numFieldsH];

        Path lastOne = null;

        for (int i = 0; i < fields.length; i++) {
            Path newOne = new Path(i*global.getFieldSideLenght(), 2*global.getFieldSideLenght());
            if(lastOne != null){
                lastOne.setNext(newOne);
            }
            fields[i][2] = newOne;
            lastOne = newOne;
        }

        AbstractCreature creature = new Dot(0,0, (Path)fields[0][2]);

        registerCreature(creature);

        registerTurret(new RectangleTurret(300,30));

        registerProjectile(new SimpleSingletargetProjectile(300,300,1,3,creature));

    }

    public void drawMe(Graphics graphics) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                AbstractField current = fields[i][j];
                if(current != null)
                    current.drawMe(graphics);
            }
        }

        super.drawMe(graphics);

    }

    List<AbstractCreature> getAllCurrentCreatures() {
        return null;
        //todo
    }
}
