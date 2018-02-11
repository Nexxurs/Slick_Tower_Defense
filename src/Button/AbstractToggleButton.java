package Button;

import Singletons.Global;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import util.MouseUtil;

public abstract class AbstractToggleButton extends AbstractButton {

    private boolean borderBool;

    public AbstractToggleButton(float posX, float posY, float size) {
        super(posX, posY, size);
    }

    @Override
    public void drawMe(Graphics graphics) {
        Shape mouse = MouseUtil.createMouseShape();
        if(mouse.intersects(getShape())){
            if(Global.getInstance().getGameContainer().getInput().isMousePressed(0)){
                onClick(0);
            }
        }

        if(borderBool){
           drawBorder(graphics);
        }

        graphics.texture(getShape(),getImage(), true);
    }

    @Override
    public void update(int delta) {
    }

    @Override
    protected void onClick(int button) {
        borderBool = !borderBool;
        onToggle(borderBool);
    }

    protected abstract void onToggle(boolean value);
}
