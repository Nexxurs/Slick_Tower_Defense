package Map;

import Creatures.Dot;
import Map.Field.AbstractField;
import Map.Field.GrassField;
import Map.Field.Path;
import Turret.RectangleTurret;
import Singletons.Global;
import org.newdawn.slick.Graphics;


public class SimpleMap extends AbstractMap {
    private static final int spawnCD = 1000;

    private AbstractField[][] fields;
    private Path firstPath = null;
    private int spawnTimer = spawnCD;

    private Global global = Global.getInstance();



    public SimpleMap(int w, int h){
        super(w,h);

        this.fields = new AbstractField[global.getNumFieldsWidth()][global.getNumFieldsHeight()];
        Path lastOne = null;

        int currX = 0;
        int currY = 2;


        for (int i = 0; i < 35; i++) {
            Path field = new Path(currX, currY);
            if(firstPath == null){
                firstPath = field;
            }

            if(lastOne != null)
                lastOne.setNext(field);
            fields[currX][currY] = field;
            lastOne = field;
            if((i/5) % 2 == 0){
                currX++;
            } else if((i/5) % 4 == 1) {
                currY++;
            } else {
                currY--;
            }
        }

        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if(fields[i][j] == null){
                    fields[i][j] = new GrassField(i,j);
                }
            }
        }

        registerTurret(new RectangleTurret(6,6));
        registerTurret(new RectangleTurret(11,3));
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

    private int oldSM=global.getSpeedMultiplicator();

    @Override
    public void update(int delta) {
        super.update(delta);

        spawnTimer += (delta * global.getSpeedMultiplicator());
        if(spawnCD <= spawnTimer){
            AbstractMap map = global.getCurrentMap();
            map.registerCreature(new Dot(firstPath));
            spawnTimer = 0;
        }
    }
}
