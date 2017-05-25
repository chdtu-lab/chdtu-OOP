package Lab5;

import javax.swing.*;
import java.awt.*;

public class Cup extends JComponent {
    private String material;
    private int roominess;
    private String color;
    private double price;


    Cup(String m,  int r, String c, double p){
        this.material = m;
        this.roominess = r;
        this.color = c;
        this.price = p;
    }


    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(5));

        if(color.equals("Чорний")){
            g.setColor(Color.BLACK);
        }
        if(color.equals("Синій")){
            g.setColor(Color.BLUE);
        }
        if(color.equals("Рожевий")){
            g.setColor(Color.MAGENTA);
        }
        if(color.equals("Червоний")){
            g.setColor(Color.RED);
        }

        int m = roominess;
        int x = 5;
        int y = 5;
        int width = 70;
        int height = 100;
        g2.fillRoundRect(x,y,width * m,height * m, 25, 25);
        g2.setStroke(new BasicStroke(4 * m));
        g2.drawRoundRect(x + width * m,y + m * 20,30 * m,55 * m, 25, 25);
    }

    String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    int getRoominess() {
        return roominess;
    }

    public void setRoominess(int roominess) {
        this.roominess = roominess;
    }

    String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
