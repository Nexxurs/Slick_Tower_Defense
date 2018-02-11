package Button;

import Singletons.Global;
import interfaces.Drawable;
import interfaces.Updateable;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import util.MouseUtil;

public abstract class AbstractButton implements Drawable, Updateable {

    private static final int CLICKED_BORDER_DURATION = 100;
    private int borderDuration = 0;
    private Shape shape;

    public AbstractButton(float posX, float posY, float size){
        shape = new Rectangle(posX, posY,size,size);
    }

    public Shape getShape(){
        return shape;
    }

    public abstract Image getImage();

    protected abstract void onClick(int button);

    @Override
    public void drawMe(Graphics graphics) {
        Shape mouse = MouseUtil.createMouseShape();
        if(mouse.intersects(getShape())){
            if(Global.getInstance().getGameContainer().getInput().isMousePressed(0)){
                onClick(0);
                borderDuration = CLICKED_BORDER_DURATION;
            }
        }

        if(borderDuration > 0){
            drawBorder(graphics);
        }

        graphics.texture(getShape(),getImage(), true);
    }

    protected void drawBorder(Graphics graphics){
        graphics.setLineWidth(5);
        graphics.setColor(Color.black);
        graphics.draw(getShape());
        graphics.resetLineWidth();
    }

    @Override
    public void update(int delta) {
        borderDuration = Math.max(0, borderDuration-delta);
    }
}
