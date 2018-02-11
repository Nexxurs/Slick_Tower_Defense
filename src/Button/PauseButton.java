package Button;

import Singletons.Global;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import util.ImageUtil;

public class PauseButton extends AbstractButton {
    private Image image;

    public PauseButton(float posX, float posY, float size){
        super(posX,posY,size);
        image = ImageUtil.loadImage("pic/pause.png");
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    protected void onClick(int button) {
        GameContainer gc = Global.getInstance().getGameContainer();
        gc.setPaused(!gc.isPaused());
    }
}
