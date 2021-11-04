package Examples.TextArea;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Solution {
    public static void main(String []args){
        ButtonFrame frame= new ButtonFrame();//создаем фрейм
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//операция отвечающая за окончание программы после закрытия фрейма
        frame.setVisible(true);//делаем фрейм видимым
    }
}
class ButtonFrame extends JFrame{//создаем класс отвечающий за фрейм
    public ButtonFrame(){//конструктор данного класа
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHE);//размеры фрейма
        setTitle("Button");//название фрейма
        ButtonPanel panel=new ButtonPanel();//создаем панель
        add(panel);//добавляем панель на фрейм
    }
    public static final  int DEFAULT_WIDTH=300;
    public static final  int DEFAULT_HEIGHE=200;
}
class ButtonPanel extends JPanel{//класс отвечающий за фрейм
    JTextField textField=new JTextField(20);
    JTextArea textArea=new JTextArea(10,30);
    public ButtonPanel(){ //конструктор панелиadd(textField);

        JButton yellowButton=new JButton("yellow");//создаем кнопки(в качестве параметра текст отображаемы на кнопке)
        JButton blueButton=new JButton("blue");
        JButton redButton=new JButton("red");
        add(yellowButton);//добавляем кнопки на панель
        add(blueButton);
        add(redButton);
        ColorAction yellowAction=new ColorAction(Color.yellow);//создаем событие для каждого цвета(параметр-цвет)
        ColorAction blueAction=new ColorAction(Color.blue);
        ColorAction redAction=new ColorAction(Color.red);
        yellowButton.addActionListener(yellowAction);//передаем каждое событие соответствующей кнопке
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);

        add(textArea);
        textArea.setLineWrap(true);

    }

    private class ColorAction implements ActionListener{//реализуем интерфейс отвечающий за события
        public ColorAction(Color c ){//конструктор получает цвет в качестве параметра
            backgroundColor=c;
            s=c.toString();

        }
        public void actionPerformed(ActionEvent event){//реакция на нажатие кнопки-смена цвета панели
            setBackground(backgroundColor);
            textField.setText(s);
            textArea.append(s+ "\n");
        }
        private Color backgroundColor;
        private String  s;

    }

}