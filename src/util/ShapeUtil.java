package util;

import Singletons.Global;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class ShapeUtil {

    private static Global global = Global.getInstance();

    public static float getDistanceBetweenShapeCenters(Shape first, Shape second){
        float a = first.getCenterX()-second.getCenterX();
        float b = first.getCenterY()-second.getCenterY();
        return (float) Math.abs(Math.sqrt((a*a)+(b*b)));
    }

    public  static void moveShapeToDestination(Shape shape, float posX, float posY, float movespeed, int delta){
        Vector2f vec = new Vector2f(posX, posY);
        moveShapeToDestination(shape, vec, movespeed, delta);
    }

    public static void moveShapeToCenter(Shape shape, Shape destination, float movespeed, int delta){
        Vector2f vec = new Vector2f(destination.getCenterX(), destination.getCenterY());
        moveShapeToDestination(shape, vec, movespeed, delta);
    }

    public static void moveShapeToDestination(Shape shape, Vector2f destination, float movespeed, int delta){
        Vector2f vector = new Vector2f(destination.x - shape.getCenterX(), destination.y - shape.getCenterY());
        vector = vector.getNormal();

        //ms*100/delta
        vector = vector.scale(movespeed*delta/100* global.getSpeedMultiplicator());
        shape.setLocation(shape.getLocation().add(vector));
    }


}
