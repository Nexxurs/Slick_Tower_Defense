package Turret;

import main.Global;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class RectangleTurret extends AbstractTurret {

    private Shape shape, range;

    public RectangleTurret(int posX, int posY){
        Global global = Global.getInstance();


        float width = global.getFieldSideLenght()*0.6f;
        float height = global.getFieldSideLenght()*0.9f;

        float x = posX + ((global.getFieldSideLenght() - width)/2);
        float y = posY + ((global.getFieldSideLenght() - height)/2);



        this.shape = new Rectangle(x,y, width,height);
        this.range = new Circle(posX+(global.getFieldSideLenght()/2), posY+(global.getFieldSideLenght()/2), 200);
    }

    protected Shape getShape() {
        return shape;
    }

    protected Shape getRange() {
        return range;
    }

    public void drawMe(Graphics graphics) {
        super.drawMe(graphics);
        graphics.setColor(Color.blue);
        graphics.fill(shape);
    }

    public void update(int delta) {

    }
}
