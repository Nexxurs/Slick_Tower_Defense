package util;

import org.newdawn.slick.geom.Shape;

public class ShapeUtil {

    public static float getDistanceBetweenShapeCenters(Shape first, Shape second){
        float a = first.getCenterX()-second.getCenterX();
        float b = first.getCenterY()-second.getCenterY();
        return (float) Math.abs(Math.sqrt((a*a)+(b*b)));
    }
}
