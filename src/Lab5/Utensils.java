package Lab5;


import javax.swing.*;
import java.awt.*;

public class Utensils extends JComponent {

    private String material;
    private String color;
    private String all;
    private int roominess;

    Utensils(String m, String c, int r){
        this.material = m;
        this.color = c;
        this.roominess = r;
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

    int getRoominess() {
        return roominess;
    }

    public void setRoominess(int roominess) {
        this.roominess = roominess;
    }

    String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    String getColor() {
        return color;
    }

    String getAll() {
        all = "Матеріал чашки " + material + "\n" +
                "Обем чашки " + roominess + "\n" +
                "Колір чашки " + color + "\n";
        return all;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
