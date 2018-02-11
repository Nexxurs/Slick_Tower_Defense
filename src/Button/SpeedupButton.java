package Button;

import Singletons.Global;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import util.ImageUtil;

public class SpeedupButton extends AbstractToggleButton {
    private Global global = Global.getInstance();
    private Image image;

    public SpeedupButton(float posX, float posY, float size) {
        super(posX, posY, size);
        image = ImageUtil.loadImage("pic/speedup.png");
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    protected void onToggle(boolean value) {
        if (value){
            global.setSpeedMultiplicator(global.DEFAULT_SPEED_MULTIPLICATOR*2);
        }else {
            global.setSpeedMultiplicator(global.DEFAULT_SPEED_MULTIPLICATOR);
        }

    }
}
