package Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Telephone extends JPanel {
    private Color col;
    private String maker;
    private int prise;
    private Color clr;

    Telephone() {
    }

    //Конструктори
    Telephone(String m) {
        maker = m;
    }

    Telephone(String m, int p) {
        maker = m;
        prise = p;
    }
    //Методи
    public void paint (Graphics g) {
        g.setColor(col);
        g.drawRect(10,15, prise,50);
        g.drawString(maker, 50, 10);
    }

    void DrawWindow() {
        JFrame SetWin = new JFrame("Setting telephone");
        GridLayout gbl = new GridLayout(4,1);
        SetWin.setLayout(gbl);
        SetWin.setLocation(0,350);

        clr = Color.white;
        JButton changeCol = new JButton("");
        changeCol.setBackground(clr);

        String[] listMaterials = {
                "Alcatel",
                "Panasonic",
                "Philips",
                "Texet"
        };
        JComboBox mak = new JComboBox(listMaterials);

        JTextField  prs = new JTextField();
        JLabel L_SetCol = new JLabel("Color:");
        JLabel L_mat = new JLabel("Maker:");
        JLabel L_prs = new JLabel("Prise:");
        JButton apply = new JButton("Input data");

        SetWin.getContentPane().add(L_SetCol);
        SetWin.getContentPane().add(changeCol);
        SetWin.getContentPane().add(L_mat);
        SetWin.getContentPane().add(mak);
        SetWin.getContentPane().add(L_prs);
        SetWin.getContentPane().add(prs);
        SetWin.getContentPane().add(apply);

        SetWin.setVisible(true);
        SetWin.setSize(500,300);

        changeCol.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            clr = JColorChooser.showDialog(null, "Choose a background",clr);
                                            changeCol.setBackground(clr);
                                        }
                                    }
        );

        apply.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        inputData(clr,mak,prs);
                                    }
                                }
        );
    }

    private void inputData(Color color, JComboBox mak, JTextField prs) {
        col = color;
        maker = (String)mak.getSelectedItem();
        prise = Integer.parseInt(prs.getText());
    }

    String outputData() {
        return "col:"+col+"\n"+"maker:"+maker+"\n"+"prise:"+prise;
    }
}
