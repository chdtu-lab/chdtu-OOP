package Lab5;


import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Run extends JFrame {
    private Cup c;
    private Utensils utensils;

    private String material;
    private int roominess;
    private String color;
    private double price;

    private JComboBox materialbox, colorbox;
    private JTextField priceField = new JTextField(10);
    private JButton createCup;
    private JButton updateCup;
    private JButton getInfo;
    private ButtonGroup g = new ButtonGroup();
    private JTextArea textArea=new JTextArea(5,30);

    private Run(String title){
        super(title);
        setSize(500, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        String[] materials = {"Фарфор", "Фаянс", "Кераміка", "Скло", "Метал"};
        materialbox = new JComboBox(materials);

        String[] colors = {"Чорний", "Синій", "Рожевий", "Червоний"};
        colorbox = new JComboBox(colors);

        JLabel materialLabel = new JLabel("Оберыть матеріал чашки");
        JLabel roominessLabel = new JLabel("Оберіть обєм чашки мл");
        JLabel colorLabel = new JLabel("Оберіть колір чашки");
        JLabel priceLabel = new JLabel("Ціна чашки");
        createCup = new JButton("Створити чашку");
        updateCup = new JButton("Оновити данні");
        getInfo = new JButton("Отримати нформацію");

        JRadioButton rb1 = new JRadioButton("2");
        JRadioButton rb2 = new JRadioButton("3");
        JRadioButton rb3 = new JRadioButton("4");

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

        add(propPenel, BorderLayout.EAST);

        JPanel bb = new JPanel();
        bb.setLayout(new GridLayout(0, 2));
        bb.add(createCup);
        bb.add(updateCup);
        bb.add(getInfo);
        bb.add(textArea);
        add(bb, BorderLayout.SOUTH);
        textArea.setLineWrap(true);

        Handler fh = new Handler();
        materialbox.addActionListener(fh);
        rb1.addActionListener(fh);
        rb2.addActionListener(fh);
        rb3.addActionListener(fh);
        colorbox.addActionListener(fh);
        createCup.addActionListener(fh);
        updateCup.addActionListener(fh);
        getInfo.addActionListener(fh);
    }

    public String getMaterial() {
        return (String) materialbox.getSelectedItem();
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getRoominess() {
        for (Enumeration<AbstractButton> buttons = g.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return Integer.parseInt(button.getText());
            }
        }
        return 1;
    }

    public void setRoominess(int roominess) {
        this.roominess = roominess;
    }

    public String getColor() {
        return (String) colorbox.getSelectedItem();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return Double.parseDouble(priceField.getText());
    }

    public void setPrice(double price) {
        this.price = price;
    }


    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == createCup) {
                material = getMaterial();
                color = getColor();
                price = getPrice();
                roominess = getRoominess();
                System.out.println(roominess);

                if (c != null){
                    Run.this.remove(c);
                }
                c = new Cup(material, roominess, color, price);
                Run.this.add(c);

//                textArea.setText(c.getAll());
            }

            if (e.getSource() == updateCup) {
                c.setMaterial(getMaterial());
                c.setRoominess(getRoominess());
                c.setColor(getColor());
                c.setPrice(getPrice());

//                textArea.setText(c.getAll());
            }
            if (e.getSource() == getInfo) {
                textArea.setText(c.getAll());
            }
        }
    }

    public static void main(String[] args) {
        Run frame = new Run("Наслыдування");
        frame.setVisible(true);
    }
}
