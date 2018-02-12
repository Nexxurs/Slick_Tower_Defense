package SideElement;

import Button.AbstractButton;
import Button.PauseButton;
import Button.SpeedupButton;
import Singletons.Bank;
import interfaces.Drawable;
import interfaces.Updateable;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.awt.Font;
import java.util.LinkedList;
import java.util.List;

public class Header implements Drawable, Updateable {

    private List<AbstractButton> buttons;
    private Shape background;
    private int width, height;

    private TrueTypeFont trueTypeFont;

    public Header(int width, int height){
        float btnSize = height*0.8f;
        background = new Rectangle(0,0,width,height);
        this.width = width;
        this.height = height;
        Font font = new Font("Verdana", Font.PLAIN, 15);
        trueTypeFont = new TrueTypeFont(font, true);

        buttons = new LinkedList<>();

        AbstractButton pauseBtn = new PauseButton(width-height, height*0.1f, btnSize);
        AbstractButton speedupBtn = new SpeedupButton(width-(2*height),height*0.1f, btnSize);

        buttons.add(pauseBtn);
        buttons.add(speedupBtn);
    }

    @Override
    public void drawMe(Graphics graphics) {
        graphics.setColor(new Color(145,107,96));
        graphics.fill(background);

        Bank bank = Bank.getInstance();
        int balance = (int)bank.getBalance();
        String str = balance+" Gold";

        trueTypeFont.drawString(10,10, str);

        for (AbstractButton btn: buttons){
            btn.drawMe(graphics);
        }

    }

    @Override
    public void update(int delta) {

        for (AbstractButton btn: buttons){
            btn.update(delta);
        }
    }
}
