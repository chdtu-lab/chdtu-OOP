package Examples.Ex1;
import javax.swing.*;
import java.awt.*;

/**
 * Created by andriy on 20.02.17.
 */
public class Run extends JFrame{

    JLabel l;
    JTextField field;

    private Run(String title){
        super(title);
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        Container c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER,20,30));
        l = new JLabel("Hello World");
        field = new JTextField(10);
        c.add(l);
        c.add(field);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Run("Window");
    }
}
