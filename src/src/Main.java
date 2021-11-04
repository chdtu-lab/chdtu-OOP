package src;

import org.w3c.dom.html.HTMLImageElement;
import sun.security.krb5.internal.PAData;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by andy on 09.05.17.
 */
public class Main extends JFrame{
    final int SET_X_LABEL = 150,SET_Y = 5, WIDTH = 100, SET_X_INPUT = 2, HEIGHT = 30;
    private TrainTicket  ticket;
    private ArrayList<String> strlList = setLists();

    private JPanel jPanel = new JPanel();
    private JPanel panel = new JPanel();
    private JPanel textAria = new JPanel();


    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextArea text = new JTextArea();
    private String train[] = {"148 K", "152 K", "143 K", "120 K"};
    private JComboBox trainNumber = new JComboBox(train);
    private JTextField name = new JTextField();
    private JTextField surname = new JTextField();
    private JSpinner seatNum = new JSpinner(spinnerModel(1,1,30,1));
    private String seaty1[] = {"Київ","Харків","Одеса","Дніпро"};
    private JComboBox start = new JComboBox(seaty1);
    private String seaty2[] = {"Полтава", "Чернігів", "Черкаси", "Львів"};
    private JComboBox end = new JComboBox(seaty2);
    private JSpinner day = new JSpinner(spinnerModel(1,1,30,1));
    private JSpinner month = new JSpinner(spinnerModel(1,1,12,1));
    private JSpinner year = new JSpinner(spinnerModel(17,17,20,1));
    private JSpinner carNumber = new JSpinner(spinnerModel(1,1,10,1));
    private JButton seatAll = new JButton("OK");


//    * https://habrahabr.ru/company/alee/blog/127518/
//    * http://sbp-program.ru/java/sbp-graphics.htm


    private SpinnerModel spinnerModel(int x1 ,int x2, int x3, int x4){
        return new SpinnerNumberModel(x1, x2, x3, x4);
    }

    private void createInterfase() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Лабараторна робота №5");
        panel.setLayout(null);
        jPanel.setLayout(null);
        textAria.setLayout(null);
        tabbedPane.setBounds(2,2,400,400);
        this.createTextFiled();
        this.createLabel();
        tabbedPane.add("Write",panel);
        tabbedPane.add("Read",jPanel);
        tabbedPane.add("TextAria",textAria);
        this.getContentPane().add(tabbedPane);
        this.setSize(400,450);
        this.setVisible(true);
    }

    private ArrayList<String> setLists() {
        ArrayList<String> list = new ArrayList<String>();
        String[] str = {"Введіті номер потяга", "Введіть номер вагона", "Введіть наомер місця", "Введеіть місце відправлення", "Введіть місце прибуття", "Введіть дату відправлення", "Введіть ім'я","Введіть прізвище", "Введіть прізвище"};
        for (int i = 0; i < 8; i++) {
            list.add(str[i]);
        }

        return list;
    }


    private void createLabel() {
        List<JLabel> list = new ArrayList<JLabel>();
        list.add(new JLabel(strlList.get(0)));
        list.get(0).setBounds(SET_X_LABEL,SET_Y,WIDTH * 2,HEIGHT);
        panel.add(list.get(0));


        for (int i = 1; i < 8; i++) {
            list.add(new JLabel(strlList.get(i)));
            list.get(i).setBounds(SET_X_LABEL, (SET_Y * 2  + HEIGHT) * i,WIDTH * 2,HEIGHT);
            panel.add(list.get(i));
        }


    }


    private void allBtnLisner() {
        seatAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date(Integer.parseInt(year.getValue().toString()), Integer.parseInt(month.getValue().toString())-1, Integer.parseInt(day.getValue().toString()));
                ticket = new TrainTicket();
                ticket.setTrainNumber(trainNumber.getItemAt(trainNumber.getSelectedIndex()).toString());
                ticket.setCarNumber(Integer.parseInt(carNumber.getValue().toString()));
                ticket.setSeatNumber(Integer.parseInt(seatNum.getValue().toString()));
                ticket.setPlaceSend(start.getItemAt(start.getSelectedIndex()).toString());
                ticket.setPlaceArrival(end.getSelectedItem().toString());
                ticket.setDateSend(date);
                ticket.setNameClient(name.getText());
                ticket.setSurnameClient(surname.getText());

                System.out.println("I have wroute");
                JOptionPane.showMessageDialog(panel, "Записано");

                String[] arrStr = {"Номер потяга: " + ticket.getTrainNumber(),"Номер вагона: " + ticket.getCarNumber(),"Номер місця: " + ticket.getSeatNumber(), "Місце відправлення: " + ticket.getPlaceSend(), "Місце прибуття: " + ticket.getPlaceArrival(),"Дата відправлення: " + ticket.getDateSend(), "Ім'я: " + ticket.getNameClient(), "Прізвище: " + ticket.getSurnameClient()};


                List<JLabel> list = new ArrayList<JLabel>();
                list.add( new JLabel(arrStr[0]));
                list.get(0).setBounds(SET_Y * 2, SET_Y, WIDTH * 2, HEIGHT);
                jPanel.add(list.get(0));

                for (int i = 1; i < 8; i++) {
                    list.add(new JLabel(arrStr[i]));
                    list.get(i).setBounds(SET_Y * 2, (SET_Y * 2 + HEIGHT) * i, WIDTH * 3, HEIGHT);
                    jPanel.add(list.get(i));
                }

                ticket.setText("Місце відправлення: " + ticket.getPlaceSend() + "\n" +
                        "Місце прибуття: " + ticket.getPlaceArrival() + "\n" +
                        "Дата відправлення: " + ticket.getDateSend() + "\n");
                text.setText(ticket.getText());
                text.setFont(new Font("Serif", Font.ITALIC, 16));
                text.setLineWrap(true);
                text.setWrapStyleWord(true);
            }
        });

    }


    private void createTextFiled() {

//        Номер потяга
        trainNumber.setBounds(SET_X_INPUT,SET_Y,80,HEIGHT);
        panel.add(trainNumber);

//        Номер вагона
        carNumber.setBounds(SET_X_INPUT,(SET_Y * 2 + HEIGHT) * 1,40,HEIGHT);
        panel.add(carNumber);

//        Місце пасажира
        seatNum.setBounds(SET_X_INPUT,(SET_Y * 2 + HEIGHT) * 2,40,HEIGHT);
        panel.add(seatNum);

//        Місце відправки
        start.setBounds(SET_X_INPUT,(SET_Y * 2 + HEIGHT) * 3,WIDTH,HEIGHT);
        panel.add(start);

//        Місце прибуття
        end.setBounds(SET_X_INPUT,(SET_Y * 2 + HEIGHT) * 4,WIDTH,HEIGHT);
        panel.add(end);

//       Дата
        day.setBounds(SET_X_INPUT,(SET_Y * 2 + HEIGHT) * 5,40,HEIGHT);
        panel.add(day);

        month.setBounds(42,(SET_Y * 2 + HEIGHT) * 5,40,HEIGHT);
        panel.add(month);

        year.setBounds(82,(SET_Y * 2 + HEIGHT) * 5,40,HEIGHT);
        panel.add(year);

//        І'мя пасажира
        name.setBounds(SET_Y,(SET_Y * 2 + HEIGHT) * 6,WIDTH,HEIGHT);
        panel.add(name);

//        Прізвище пасажира
        surname.setBounds(SET_Y,(SET_Y * 2 + HEIGHT) * 7,WIDTH,30);
        panel.add(surname);

        text.setBounds(SET_Y,SET_Y,(SET_Y * 2 + HEIGHT) * 8,350);
        textAria.add(text);

        seatAll.setBounds(SET_Y, (SET_Y * 2 + HEIGHT) * 8, WIDTH, HEIGHT);
        panel.add(seatAll);
        allBtnLisner();
    }


    public Main() {
        this.createInterfase();

    }

    public static void main(String args[]) {
        Main app = new Main();
    }

}
