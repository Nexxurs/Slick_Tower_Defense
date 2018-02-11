package util;

import main.Global;
import org.newdawn.slick.geom.Vector2f;

public class MapUtil {

    static Global global = Global.getInstance();

    public static Vector2f fieldPosToVector(int x, int y){
        return new Vector2f(global.getFieldSideLenght()*x, global.getFieldSideLenght()*y);
    }

    public static Vector2f fieldPosToVectorCenter(int x, int y){
        int offset = global.getFieldSideLenght()/2;
        return new Vector2f(global.getFieldSideLenght()*x+offset, global.getFieldSideLenght()*y+offset);
    }

    public static int posToFieldPos(float x){
        return (int)(x/global.getFieldSideLenght());
    }
}
