package Creatures;

import Map.Field.Path;
import interfaces.Drawable;
import interfaces.Updateable;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

public abstract class AbstractCreature implements Drawable, Updateable {

    private float health;
    protected Shape shape;
    private boolean despawn;
    private Path nextPath;

    public AbstractCreature(Shape shape, Path startPath, float health){
        this.shape = shape;
        this.health = health;
        this.despawn = false;
        nextPath = startPath;
    }

    protected abstract float getMovespeed();

    public void update(int delta) {
        if(health <=0){
            despawn = true;
        }

        float[] moveVector = getMovementVector(shape, nextPath.getShape());

        //ms*100/delta
        float transX = moveVector[0]*getMovespeed()*100/delta;
        float transY = moveVector[1]*getMovespeed()*100/delta;

        Transform transform = Transform.createTranslateTransform(transX, transY);

        shape.transform(transform);

        float[] afterVector = getMovementVector(shape, nextPath.getShape());
        if(afterVector[0] != moveVector[0] || afterVector[1] != moveVector[1]){
            nextPath = nextPath.getNext();
            if(nextPath == null){
                despawn = true;
                //todo despawn gscheit machen!
            }
        }
    }

    public boolean canDespawn() {
        return despawn;
    }

    private static float[] getMovementVector(Shape me, Shape destination){
        float destX = destination.getCenterX() - me.getCenterX();
        float destY = destination.getCenterY() - me.getCenterY();

        if(destX < 0) destX = -1;
        else if(destX > 0) destX = 1;

        if(destY < 0) destY = -1;
        else if(destY > 0) destY = 1;

        return new float[]{destX, destY};
    }
}
