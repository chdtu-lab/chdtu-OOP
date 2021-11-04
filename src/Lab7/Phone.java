package Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Phone extends Telephone {
	private int width;
	private int height;
	private int thickness;

	//Конструктори
	Phone(int a, int b, int c) {
		width = a;
		height = b;
		thickness = c;
	}

	Phone(int a, int b) {
		width = a;
		height = b;
		thickness = 10;
	}

	@Override
	public void paint (Graphics g) {
			g.drawOval(20, width, height, thickness);
    }

    void DrawWindow(){
		JFrame SetWin = new JFrame("Setting mobile phone");
		GridLayout gbl = new GridLayout(4,1);
		SetWin.setLayout(gbl);
		SetWin.setLocation(0,350);

		JTextField  wid = new JTextField();
		JTextField  heig = new JTextField();
		JTextField  thick = new JTextField();
		JLabel L_wid = new JLabel("width:");
		JLabel L_heig = new JLabel("height:");
		JLabel L_thick = new JLabel("thickness:");
		JButton apply = new JButton("Input data");

		SetWin.getContentPane().add(L_wid);
		SetWin.getContentPane().add(wid);
		SetWin.getContentPane().add(L_heig);
		SetWin.getContentPane().add(heig);
		SetWin.getContentPane().add(L_thick);
		SetWin.getContentPane().add(thick);
		SetWin.getContentPane().add(apply);
		SetWin.setVisible(true);
		SetWin.setSize(500,300);

		apply.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					inputData(wid,heig,thick);
				}
			}
		);
	}

	private void inputData(JTextField a, JTextField b, JTextField c) {
		width = Integer.parseInt(a.getText());
		height = Integer.parseInt(b.getText());
		thickness = Integer.parseInt(c.getText());
	}

	String outputData(){
        return "width:"+width+"\n" +"height:"+height+"\n"+"thickness:"+thickness;
	}
}
