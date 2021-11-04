package Lab1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Action extends JFrame{
    private JTextField field1 = new JTextField(10);
    private JButton button;

    Action(String title){
        super(title);
        setSize(360, 150);
        setLocationRelativeTo(null);
        Container c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER,20,30));

        button = new JButton("OK");
        JLabel label1 = new JLabel("Введыть довыльний рядок");
        c.add(label1);
        c.add(field1);
        c.add(button);

        Handler fh = new Handler();
        button.addActionListener(fh);
    }

    class Handler implements ActionListener{
        int upperCase, lowerCase;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button){
                String s1 = field1.getText();

                for (int k = 0; k < s1.length(); k++) {
                    if (Character.isUpperCase(s1.charAt(k))) upperCase++;

                    if (Character.isLowerCase(s1.charAt(k))) lowerCase++;
                }

                String message = String.format("В рядку %d великих букви та  %d малих букв", upperCase, lowerCase);
                JOptionPane.showMessageDialog(null,
                        message,
                        "Результат",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
