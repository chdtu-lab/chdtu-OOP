package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Run extends JFrame{
    private JTextField numberField = new JTextField(10);
    private JTextField tarifField = new JTextField(10);
    private JTextField phoneBillField = new JTextField(10);
    private JTextField typeField = new JTextField(10);
    private JTextField osField = new JTextField(10);
    private JTextField minuteField = new JTextField(10);
    private JTextField upgradeOSField = new JTextField(10);
    private JTextField changeTarifField = new JTextField(10);
    private JTextField RefillField = new JTextField(10);
    private JButton createObject;
    private JButton call;
    private JButton upgradeOS;
    private JButton changeTarif;
    private JButton refill;

    private Run(String title){
        super(title);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2));

        JLabel numberLabel = new JLabel("Введіть номер телефону");
        JLabel tarifLabel = new JLabel("Введіть тариф за хвилину");
        JLabel phoneBillLabel = new JLabel("Введіть початковий стан рахунку");
        JLabel typeLabel = new JLabel("Тип телефону");
        JLabel osLabel = new JLabel("Операційна система телефону");
        JLabel minuteLabel = new JLabel("час дзвынка хв");
        JLabel upgradeLabel = new JLabel("Введіть версію ОС");
        JLabel changeTarifLabel = new JLabel("Введіть нову вартість дзвінка");
        JLabel RefillLabel = new JLabel("Сумма на яку поповнити рахунок");
        createObject = new JButton("Створити обєкт");
        call = new JButton("Зателефонувати");
        upgradeOS = new JButton("оновити ОС");
        changeTarif = new JButton("оновити тариф");
        refill = new JButton("Поповнити рахунок");

        add(numberLabel);
        add(numberField);
        add(tarifLabel);
        add(tarifField);
        add(phoneBillLabel);
        add(phoneBillField);
        add(typeLabel);
        add(typeField);
        add(osLabel);
        add(osField);
        add(createObject);

        add(minuteLabel);
        add(minuteField);
        add(call);

        add(upgradeLabel);
        add(upgradeOSField);
        add(upgradeOS);

        add(changeTarifLabel);
        add(changeTarifField);
        add(changeTarif);

        add(RefillLabel);
        add(RefillField);
        add(refill);

        Handler fh = new Handler();
        createObject.addActionListener(fh);
        call.addActionListener(fh);
        upgradeOS.addActionListener(fh);
        changeTarif.addActionListener(fh);
        refill.addActionListener(fh);
    }

    public static void main(String[] args) {
        Frame frame = new Run("Обчислення Кылькості великих та малих букв");
        frame.setVisible(true);
    }

    class Handler implements ActionListener{
        Phone ph;
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == createObject){
                int n = Integer.parseInt(numberField.getText());
                double tarif = Double.parseDouble(tarifField.getText());
                int pb = Integer.parseInt(phoneBillField.getText());
                String type = typeField.getText();
                String os = osField.getText();

                ph = new Phone(n,tarif,pb, type, os);
                System.out.println(ph.getNumber());
                System.out.println(ph.getTarif());
                System.out.println(ph.getPhoneBill());
                System.out.println(ph.getType());
                System.out.println(ph.getOs());
            }

            if (e.getSource() == call){

                int min = Integer.parseInt(minuteField.getText());
                System.out.println(ph.getPhoneBill());
                ph.call(min);
                System.out.println(ph.getPhoneBill());
            }

            if (e.getSource() == upgradeOS){
                String version = upgradeOSField.getText();
                System.out.println(ph.getOs());
                ph.upgradeOs(version);
                System.out.println(ph.getOs());
            }

            if (e.getSource() == changeTarif){
                double tarif = Double.parseDouble(changeTarifField.getText());
                System.out.println(ph.getTarif());
                ph.changeTarif(tarif);
                System.out.println(ph.getTarif());
            }

            if (e.getSource() == refill){
                double chost = Double.parseDouble(RefillField.getText());
                System.out.println(ph.getPhoneBill());
                ph.Refill(chost);
                System.out.println(ph.getPhoneBill());
            }
        }
    }
}