package Examples;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

// the four tools things we'll use to draw


public class DrawCup extends JFrame{

    private DrawCup(String title){
        super(title);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2));


    }

    public void paint (Graphics g) {
//        Rectangle r = new Rectangle(100,100,100,100);
//        g.fillRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
//        g.drawRect(100,100,100,100);

        Graphics2D g2 = (Graphics2D) g;

        // Draw a coffee cup.

        GeneralPath leftSide = new GeneralPath();

        // left side of cup
        leftSide.moveTo(200,400);
        leftSide.lineTo(160,360);
        leftSide.lineTo(130,300);
        leftSide.lineTo(100,200);
        leftSide.lineTo(100,100);

        // NOTE: AS OF 05/06/09, this isn't working yet
        // the way I hoped it would...  I'm still working out why..

        // We are trying here to see if we can create the right side
        // of the cup by copying the left side, and doing a
        // "flip across the x axis".   We first have to translate to the
        // origin, flip, and then translate back...

        AffineTransform af = new AffineTransform();

        af.translate(-100,-100);
        af.scale(-1.0, 1.0);
        af.translate(-700,100);

        Shape rightSide = leftSide.createTransformedShape(af);

        GeneralPath topAndBottom = new GeneralPath();

        topAndBottom.moveTo(100,100);
        topAndBottom.lineTo(500,100); // top of cup

        topAndBottom.moveTo(200,400);
        topAndBottom.lineTo(400,400); // bottom of cup


        g2.draw(leftSide);

        g2.setColor(Color.RED);
        g2.draw(rightSide);

        g2.setColor(Color.BLUE);
        g2.draw(topAndBottom);


        g2.drawString("A coffee cup, by Phill Conrad", 20,20);
    }

    public static void main(String[] args) {
        Frame frame = new DrawCup("Обчислення Кылькості великих та малих букв");
//        frame.paint();
        frame.setVisible(true);
    }


}
