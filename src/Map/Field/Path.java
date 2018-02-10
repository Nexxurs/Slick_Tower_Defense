package Map.Field;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Vector2f;


public class Path extends AbstractField {
    Path next;

    public Path(int posX, int posY){
        this(posX, posY, null);
    }

    public Path(int posX, int posY, Path next){
        super(posX, posY);
        this.next = next;
    }

    public Path(Vector2f vec){
        super(vec.x, vec.y);
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
