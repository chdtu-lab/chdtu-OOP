package Examples.ExBorderLayout;

import javax.swing.*;
import java.awt.*;

public class TestFrame {
    private static void CreateGUI(){
        JFrame frame = new JFrame("Test Frame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JButton northButton = new JButton("North (PGE START)");
        panel.add(northButton, BorderLayout.NORTH);
        JButton southButton = new JButton("South (PGE END)");
        panel.add(southButton, BorderLayout.SOUTH);
        JButton eastButton = new JButton("East (LINE START)");
        panel.add(eastButton, BorderLayout.EAST);
        JButton westButton = new JButton("WESt (LINE END)");
        panel.add(westButton, BorderLayout.WEST);
        JButton centerButton = new JButton("CENTER");
        panel.add(centerButton, BorderLayout.CENTER);
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(550, 300));
        frame.pack();
//        frame.setSize(550, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        CreateGUI();
    }
}
