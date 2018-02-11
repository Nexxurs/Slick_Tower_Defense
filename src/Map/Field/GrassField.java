package Map.Field;

import org.newdawn.slick.Color;

public class GrassField extends AbstractField {

    public GrassField(int fPosX, int fPosY){
        super(fPosX, fPosY);
    }

    @Override
    protected Color getFillColor() {
        return new Color(0,140,0);
    }
}
