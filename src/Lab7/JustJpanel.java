package Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JustJpanel extends JPanel{
	private int x = 10;
	private int y = 10;
	private int height = 50;
	private int width = 50;

	public void paint (Graphics g) {
		g.drawRect(x,y,height,width);
	}

	void DrawWindow() {
		JFrame SetWin = new JFrame("Setting class Jpanel");
		GridLayout gbl = new GridLayout(5,2);
		SetWin.setLayout(gbl);
		SetWin.setLocation(0,350);

		JTextField  _x = new JTextField();
		JTextField  _y = new JTextField();
		JTextField  _h = new JTextField();
		JTextField  _w = new JTextField();
		JLabel L_x = new JLabel("X:");
		JLabel L_y = new JLabel("Y:");
		JLabel L_height = new JLabel("Height:");
		JLabel L_width = new JLabel("Width:");
		JButton apply = new JButton("Input data");

		SetWin.getContentPane().add(L_x);
		SetWin.getContentPane().add(_x);
		SetWin.getContentPane().add(L_y);
		SetWin.getContentPane().add(_y);
		SetWin.getContentPane().add(L_height);
		SetWin.getContentPane().add(_h);
		SetWin.getContentPane().add(L_width);
		SetWin.getContentPane().add(_w);
		SetWin.getContentPane().add(apply);
		
		SetWin.setVisible(true);
		SetWin.setSize(600,300);

		apply.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					inputData(_x, _y, _h, _w);
				}
			}
		);
	}

	private void inputData(JTextField a, JTextField b, JTextField c, JTextField d){
		x = Integer.parseInt(a.getText());
		y = Integer.parseInt(b.getText());
		height = Integer.parseInt(c.getText());
		width = Integer.parseInt(d.getText());
	}

	String outputData(){
        return "x:"+x+"\n"+"y:"+y+"\n"+"height:"+height+"\n"+"width:"+width;
	}
}
