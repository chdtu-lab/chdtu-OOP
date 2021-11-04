package Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

class StartV2 {
	private Telephone BaseСlass;

	void StartProg() {
		JFrame window = new JFrame("Variant 2");
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
		JButton set = new JButton("Setting");
		JComboBox constr = new JComboBox(listConstr);
		JButton create = new JButton("Create");
		JTextArea result = new JTextArea();
		JButton showRes = new JButton("Output data");
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
										 if(BaseСlass != null) {
											 window.getContentPane().remove(BaseСlass);
											 BaseСlass = null;
										 }
										 if (Objects.equals((String) constr.getSelectedItem(), "Telephone(String m)")) {
											 BaseСlass = new Telephone("Alcatel");
											 window.getContentPane().repaint();
											 window.getContentPane().add(BaseСlass);
										 }
										 if (Objects.equals((String) constr.getSelectedItem(), "Telephone(String m,int p)")) {
											 BaseСlass =  new Telephone("Alcatel",143);
											 window.getContentPane().repaint();
											 window.getContentPane().add(BaseСlass);
										 }
										 if (Objects.equals((String) constr.getSelectedItem(), "Phone(int w, int h, int t)")) {
											 BaseСlass =  new Phone(23,12,43);
											 window.getContentPane().repaint();
											 window.getContentPane().add(BaseСlass);
										 }
										 if (Objects.equals((String) constr.getSelectedItem(), "Phone(int w, int h)")) {
											 BaseСlass =  new Phone(12,23);
											 window.getContentPane().repaint();
											 window.getContentPane().add(BaseСlass);
										 }
										 result.setText("Create object");
									 }
								 }
		);
		set.addActionListener(new ActionListener() {
								  public void actionPerformed(ActionEvent e) {
									  if(BaseСlass != null) {
                                          System.out.println("21");
                                          BaseСlass.DrawWindow();
									  }
								  }
							  }
		);
		showRes.addActionListener(new ActionListener() {
									  public void actionPerformed(ActionEvent e) {
										  if(BaseСlass != null) {
											  window.getContentPane().repaint();
											  window.getContentPane().add(BaseСlass);
											  result.setText(BaseСlass.outputData());
										  }
									  }
								  }
		);
	}
}
