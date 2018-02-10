package Map.Field;

import interfaces.Drawable;
import main.Global;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public abstract class AbstractField implements Drawable {

    protected float posX, posY;
    private Rectangle rect;

    public AbstractField(float posX, float posY){
        this.posX = posX;
        this.posY = posY;
    }

    protected abstract Color getFillColor();

    protected Color getLineColor(){
        return Color.darkGray;
    }

    public Shape getShape(){
        return rect;
    }

    public void drawMe(Graphics graphics) {
        if(rect == null){
            Global global = Global.getInstance();
            rect = new Rectangle(posX, posY, global.getFieldSideLenght(), global.getFieldSideLenght());
        }

        graphics.setColor(getLineColor());
        graphics.setLineWidth(2);
        graphics.draw(rect);
        graphics.setColor(getFillColor());
        graphics.fill(rect);
    }
}
