package Lab5;


import javax.swing.*;

public class Utensils extends JComponent {

    private String material;
    private String color;

    Utensils(String m, String c){
        this.material = m;
        this.color = c;
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

    public void setColor(String color) {
        this.color = color;
    }
}
