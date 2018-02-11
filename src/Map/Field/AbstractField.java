package Map.Field;

import interfaces.Drawable;
import main.Global;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import util.MapUtil;

public abstract class AbstractField implements Drawable {

    protected int fPosX, fPosY;
    private Rectangle rect;

    public AbstractField(int fPosX, int fPosY){
        this.fPosX = fPosX;
        this.fPosY = fPosY;
    }

    protected abstract Color getFillColor();

    protected Color getLineColor(){
        return Color.darkGray;
    }

    public Shape getShape(){
        return rect;
    }

    public int getFPosX() {
        return fPosX;
    }

    public int getFPosY() {
        return fPosY;
    }

    public void drawMe(Graphics graphics) {
        if(rect == null){
            Global global = Global.getInstance();
            Vector2f posVec = MapUtil.fieldPosToVector(getFPosX(),getFPosY());
            rect = new Rectangle(posVec.x, posVec.y, global.getFieldSideLenght(), global.getFieldSideLenght());
        }

        graphics.setColor(getLineColor());
        graphics.setLineWidth(2);
        graphics.draw(rect);
        graphics.setColor(getFillColor());
        graphics.fill(rect);
    }
}
