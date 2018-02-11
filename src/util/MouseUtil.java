package util;

import Singletons.Global;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class MouseUtil {
    private static Global global = Global.getInstance();

    public static Shape createMouseShape(){
        Input input = global.getGameContainer().getInput();
        return new Circle(input.getMouseX(), input.getMouseY(), 1);
    }
}
