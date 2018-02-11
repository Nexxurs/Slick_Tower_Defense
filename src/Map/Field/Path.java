package Map.Field;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Vector2f;


public class Path extends AbstractField {
    Path next;

    public Path(int fPosX, int fPosY){
        this(fPosX, fPosY, null);
    }

    public Path(int fPosX, int fPosY, Path next){
        super(fPosX, fPosY);
        this.next = next;
    }

    protected Color getFillColor() {
        return Color.lightGray;
    }

    public Path getNext(){
        return next;
    }

    public void setNext(Path next) {
        this.next = next;
    }
}
