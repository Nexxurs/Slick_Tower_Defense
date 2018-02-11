package Map.Field;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Vector2f;

public class GrassField extends AbstractField {

    public GrassField(int fPosX, int fPosY){
        super(fPosX, fPosY);
    }

    @Override
    protected Color getFillColor() {
        return new Color(0,140,0);
    }
}
