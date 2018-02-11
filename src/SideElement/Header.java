package SideElement;

import Singletons.Bank;
import interfaces.Drawable;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.awt.*;

public class Header implements Drawable {

    private Shape background;
    private int width, height;

    private TrueTypeFont trueTypeFont;

    public Header(int width, int height){
        background = new Rectangle(0,0,width,height);
        this.width = width;
        this.height = height;
        Font font = new Font("Verdana", Font.PLAIN, 15);
        trueTypeFont = new TrueTypeFont(font, true);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void drawMe(Graphics graphics) {
        graphics.setColor(new Color(145,107,96));
        graphics.fill(background);

        Bank bank = Bank.getInstance();
        int balance = (int)bank.getBalance();
        String str = balance+" Gold";

        trueTypeFont.drawString(10,10, str);
    }
}
