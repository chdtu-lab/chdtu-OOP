package Lab4;

import javax.swing.*;
import java.awt.*;


public class Run extends JFrame {
    private JComboBox materialbox, colorbox, substancebox;
    private JRadioButton rb1, rb2, rb3;
    private JTextField roominessField = new JTextField(10);
    private JTextField occupancyField = new JTextField(10);
    private JButton createObject;
    private JPanel p1;

    Run(String title){
        super(title);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2));
        String[] materials = {"Фарфор", "Фаянс", "Керамика", "Стекло", "Металл"};
        materialbox = new JComboBox(materials);

        String[] colors = {"Черный", "Синий", "Розовый", "Красный"};
        colorbox = new JComboBox(colors);

        String[] substances = {"Чай", "Кофе", "Сок", "Молоко", "Ряжанка"};
        substancebox = new JComboBox(substances);

        JLabel materialLabel = new JLabel("Оберыть матеріал чашки");
        JLabel roominessLabel = new JLabel("Оберіть обєм чашки");
        JLabel colorLabel = new JLabel("Оберіть колір чашки");
        JLabel substanceLabel = new JLabel("Оберіть чим заповнена чашка");
        JLabel occupancyLabel = new JLabel("На стільки заповнена чашка");
        createObject = new JButton("Створити обєкт");



        rb1 = new JRadioButton("0.2");
        rb2 = new JRadioButton("0.3");
        rb3 = new JRadioButton("0.4");
        ButtonGroup g = new ButtonGroup();
        g.add(rb1);
        g.add(rb2);
        g.add(rb3);

        p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,20,30));
        p1.add(rb1);
        p1.add(rb2);
        p1.add(rb3);

        add(materialLabel);
        add(materialbox);
        add(roominessLabel);
        add(p1);
        add(colorLabel);
        add(colorbox);
        add(substanceLabel);
        add(substancebox);
        add(occupancyLabel);
        add(createObject);



    }

    public static void main(String[] args) {
        Frame frame = new Run("Обчислення Кылькості великих та малих букв");
        frame.setVisible(true);
    }

}
