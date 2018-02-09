package util;

import main.Global;
import org.newdawn.slick.geom.Vector2f;

public class MapUtil {

    public static Vector2f fieldPosToVector(int x, int y){
        Global global = Global.getInstance();
        return new Vector2f(global.getFieldSideLenght()*x, global.getFieldSideLenght()*y);
    }

    public static int posToFieldPos(float x){
        Global global = Global.getInstance();
        return (int)(x/global.getFieldSideLenght());
    }
}
