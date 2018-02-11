package util;

import Singletons.Global;
import main.Main;
import org.newdawn.slick.geom.Vector2f;

public class MapUtil {

    private static Global global = Global.getInstance();

    public static Vector2f fieldPosToVector(int x, int y){
        float posX = global.getFieldSideLenght()*x ;
        float posY = global.getFieldSideLenght()*y + Main.HEADER_HEIGHT;

        return new Vector2f(posX, posY);
    }

    public static Vector2f fieldPosToVectorCenter(int x, int y){
        int offset = global.getFieldSideLenght()/2;
        Vector2f vec = fieldPosToVector(x,y);
        vec.x+=offset;
        vec.y+=offset;

        return vec;
    }

    public static int posToFieldPos(float x){
        return (int)(x/global.getFieldSideLenght());
    }
}
