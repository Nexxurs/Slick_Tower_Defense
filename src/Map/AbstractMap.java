package Map;

import interfaces.Drawable;
import interfaces.Updateable;

public abstract class AbstractMap implements Drawable, Updateable {

    protected int width, height;

    public AbstractMap(int width, int height){
        this.width = width;
        this.height = height;
    }
}
