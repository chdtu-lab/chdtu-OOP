package Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

class StartV1 {
    private Telephone telephone;
    private Phone phone;
    void StartProg() {
        JFrame window = new JFrame("Variant 1");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Елементи інтерфейсу:
        GridLayout gbl = new GridLayout(3,2);
        window.setLayout(gbl);

        String[] listConstr = {
                "Telephone(String m)",
                "Telephone(String m,int p)",
                "Phone(int w, int h, int t)",
                "Phone(int w, int h)"
        };
        JButton create = new JButton("Create");
        JButton showRes = new JButton("Output data");
        JButton set = new JButton("Setting");
        JComboBox constr = new JComboBox(listConstr);
        JTextArea result = new JTextArea();
        //Виведення елементів в вікно
        window.getContentPane().add(constr);
        window.getContentPane().add(create);
        window.getContentPane().add(showRes);
        window.getContentPane().add(result);
        window.getContentPane().add(set);

        window.setVisible(true);
        window.setSize(500,300);

        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(telephone != null) {
                    window.getContentPane().remove(telephone);
                    telephone = null;
                }
                if(phone != null) {
                    window.getContentPane().remove(phone);
                    phone = null;
                }
                if (Objects.equals((String) constr.getSelectedItem(), "Telephone(String m)")) {
                    telephone = new Telephone("Alcatel");
                    window.getContentPane().repaint();
                    window.getContentPane().add(telephone);
                }
                if (Objects.equals((String) constr.getSelectedItem(), "Telephone(String m,int p)")) {
                    telephone =  new Telephone("Alcatel",143);
                    window.getContentPane().repaint();
                    window.getContentPane().add(telephone);
                }
                if (Objects.equals((String) constr.getSelectedItem(), "Phone(int w, int h, int t)")) {
                    phone =  new Phone(23,12,43);
                    window.getContentPane().repaint();
                    window.getContentPane().add(phone);
                }
                if (Objects.equals((String) constr.getSelectedItem(), "Phone(int w, int h)")) {
                    phone =  new Phone(12,23);
                    window.getContentPane().repaint();
                    window.getContentPane().add(phone);
                }
                result.setText("Create object");
            }
        });

        set.addActionListener(new ActionListener() {
                                  public void actionPerformed(ActionEvent e) {
                                      if(telephone != null) {
                                          telephone.DrawWindow();
                                      }
                                      if(phone != null) {
                                          phone.DrawWindow();
                                      }
                                  }
                              }
        );
        showRes.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent e) {
                                          if(telephone != null) {
                                              window.getContentPane().repaint();
                                              window.getContentPane().add(telephone);
                                              result.setText(telephone.outputData());
                                          }
                                          if(phone != null) {
                                              window.getContentPane().repaint();
                                              window.getContentPane().add(phone);
                                              result.setText(phone.outputData());
                                          }
                                      }
                                  });
    }
}
