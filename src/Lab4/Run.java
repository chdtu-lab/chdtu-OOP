package Lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Run extends JFrame {
    private JComboBox materialbox, colorbox;
    private JRadioButton rb1, rb2, rb3;
    private JTextField priceField = new JTextField(10);
    private JButton createCup;
    private JTextArea textArea=new JTextArea(5,30);

    private Run(String title){
        super(title);
        setSize(450, 450);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER,20,30));
        String[] materials = {"Фарфор", "Фаянс", "Кераміка", "Скло", "Метал"};
        materialbox = new JComboBox(materials);

        String[] colors = {"Чорний", "Синій", "Рожевий", "Червоний"};
        colorbox = new JComboBox(colors);

        JLabel materialLabel = new JLabel("Оберыть матеріал чашки");
        JLabel roominessLabel = new JLabel("Оберіть обєм чашки мл");
        JLabel colorLabel = new JLabel("Оберіть колір чашки");
        JLabel priceLabel = new JLabel("Ціна чашки");
        createCup = new JButton("Створити чашку");

        rb1 = new JRadioButton("200");
        rb2 = new JRadioButton("300");
        rb3 = new JRadioButton("400");
        ButtonGroup g = new ButtonGroup();
        g.add(rb1);
        g.add(rb2);
        g.add(rb3);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
        p1.add(rb1);
        p1.add(rb2);
        p1.add(rb3);

        JPanel propPenel = new JPanel();
        propPenel.setLayout(new GridLayout(0, 2));
        propPenel.add(materialLabel);
        propPenel.add(materialbox);
        propPenel.add(roominessLabel);
        propPenel.add(p1);
        propPenel.add(colorLabel);
        propPenel.add(colorbox);
        propPenel.add(priceLabel);
        propPenel.add(priceField);


        add(propPenel);
        add(createCup);
        add(textArea);
        textArea.setLineWrap(true);

        Handler fh = new Handler();
        materialbox.addActionListener(fh);
        rb1.addActionListener(fh);
        rb2.addActionListener(fh);
        rb3.addActionListener(fh);
        colorbox.addActionListener(fh);
        createCup.addActionListener(fh);
    }

    class Handler implements ActionListener {
        Cup c;
        String material;
        int roominess;
        String color;
        double price;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == materialbox) {
                material = (String) materialbox.getSelectedItem();
            }
            if (e.getSource() == rb1) {
                roominess = Integer.parseInt(rb1.getText());
            }
            if (e.getSource() == rb2) {
                roominess = Integer.parseInt(rb2.getText());
            }
            if (e.getSource() == rb3) {
                roominess = Integer.parseInt(rb3.getText());
            }
            if (e.getSource() == colorbox) {
                color = (String) colorbox.getSelectedItem();
            }
            if (e.getSource() == createCup) {
                price = Double.parseDouble(priceField.getText());
                c = new Cup(material, roominess, color, price);
                textArea.setText("");
                textArea.append("Створена чашка " + "\n");
                textArea.append("Матеріал чашки " + c.getMaterial() + "\n");
                textArea.append("Обем чашки " + c.getRoominess() + "\n");
                textArea.append("Колір чашки " + c.getColor() + "\n");
                textArea.append("Ціна чашки " + c.getPrice() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        Frame frame = new Run("Обчислення Кылькості великих та малих букв");
        frame.setVisible(true);
    }
}
