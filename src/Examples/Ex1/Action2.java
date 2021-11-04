package Examples.Ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Action2 extends JFrame{
    JTextField field1 = new JTextField(10);
    JTextField field2 = new JTextField(10);
    JButton button;
    JLabel label1 = new JLabel("Введите длину прямоугольника");
    JLabel label2 = new JLabel("Ведите ширину прямоугольника");
    JLabel label3 = new JLabel();

    Action2(String title){
        super(title);
        setSize(360, 500);
        setLocationRelativeTo(null);
        Container c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER,20,30));

        button = new JButton("OK");
        c.add(label1);
        c.add(field1);
        c.add(label2);
        c.add(field2);
        c.add(button);
        c.add(label3);

        Handler fh = new Handler();
        button.addActionListener(fh);

    }

    class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button){
                int x = Integer.parseInt(field1.getText());
                int y = Integer.parseInt(field2.getText());
                int z = x * y;
                JOptionPane.showMessageDialog(null, z, "A plain message", JOptionPane.PLAIN_MESSAGE);
                label3.setText(String.valueOf(z));
            }

        }
    }
}