package Map.Field;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Vector2f;

public class GrassField extends AbstractField {

    public GrassField(float posX, float posY){
        super(posX, posY);
    }

    public GrassField(Vector2f vec){
        super(vec.x, vec.y);
    }

    @Override
    protected Color getFillColor() {
        return new Color(0,140,0);
    }
}
