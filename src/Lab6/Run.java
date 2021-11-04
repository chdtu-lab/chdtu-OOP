package Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Run {
	public static void main(String[] args) {
		JFrame window = new JFrame("Lab6");
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		//Елементи інтерфейсу:
		GridLayout gbl = new GridLayout(3,1);
		window.setLayout(gbl);

		JLabel st = new JLabel("Select the option you start program:");
		JButton var1 = new JButton("Variant 1");
		JButton var2 = new JButton("Variant 2");

		window.getContentPane().add(st);
		window.getContentPane().add(var1);
		window.getContentPane().add(var2);

		window.setVisible(true);
		window.setSize(270,100);

		StartV1 startV1 = new StartV1();
		StartV2 startV2 = new StartV2();
		var1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				startV1.StartProg();
			}
		});

		var2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startV2.StartProg();
			}
		});
	}
}
