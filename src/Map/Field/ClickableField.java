package Map.Field;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import util.MouseUtil;


public abstract class ClickableField extends AbstractField {

    public ClickableField(int fPosX, int fPosY) {
        super(fPosX, fPosY);
    }

    public abstract void onClick();

    @Override
    public void drawMe(Graphics graphics) {
        super.drawMe(graphics);

        Shape mouse = MouseUtil.createMouseShape();
        if(mouse.intersects(getShape())){
            if(MouseUtil.isPrimaryMouseButtonClicked()){
                onClick();
            }
        }
    }
}
