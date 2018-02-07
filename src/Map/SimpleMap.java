package Map;

import Map.Field.AbstractField;
import Map.Field.Path;
import main.Global;
import org.newdawn.slick.Graphics;

public class SimpleMap extends AbstractMap {

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

    }

    public void drawMe(Graphics graphics) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                AbstractField current = fields[i][j];
                if(current != null)
                    current.drawMe(graphics);
            }
        }
    }

    public void update(int delta) {

    }
}
