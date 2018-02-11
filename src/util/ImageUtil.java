package util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageUtil {

    public static Image loadImage(String ref){
        try{
            return new org.newdawn.slick.Image(ref);
        } catch (SlickException e){
            throw new RuntimeException("Cannot find Image "+ref,e);
        }
    }
}
