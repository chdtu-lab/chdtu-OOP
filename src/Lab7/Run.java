package Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

class Run {
    private static int index = 3;
	public static void main(String[] args){
		JFrame window = new JFrame("Lab7");
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		GridLayout gbl = new GridLayout(3,0);
		window.setLayout(gbl);
		//Колекция
		List<JustJpanel> Obj = new ArrayList<>();
        final int[] ints = new Random().ints(1, 4).distinct().limit(3).toArray();

		//Заповнення колекції
		for (int i : ints) {
			if(i == 1)
				Obj.add(new JustJpanel());
			if(i == 2)
				Obj.add(new Telephone("Alcatel"));
			if(i == 3)
				Obj.add(new Phone(12,12));
		}

		String[] listObj= {
			String.valueOf(Obj.get(0).getClass()),
			String.valueOf(Obj.get(1).getClass()),
			String.valueOf(Obj.get(2).getClass())
		};

        JComboBox<String> comboBoxObj = new JComboBox<>(listObj);
		JButton sel = new JButton("Select");
		JButton set = new JButton("Setting");

		JTextArea result = new JTextArea();
		JButton showRes = new JButton("Output data");

		window.getContentPane().add(comboBoxObj);
		window.getContentPane().add(sel);
		window.getContentPane().add(showRes);
		window.getContentPane().add(result);
		window.getContentPane().add(set);

		window.setVisible(true);
		window.setSize(500,300);

		sel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (index < 3)
						window.getContentPane().remove(Obj.get(index));
					for (int i = 0; i < 3; i++)
						if(Objects.equals((String) comboBoxObj.getSelectedItem(), listObj[i]))
                            index = i;
				}
			}
		);
		set.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					(Obj.get(index)).DrawWindow();
				}
			}

		);
		showRes.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					window.getContentPane().remove(Obj.get(index));
					window.getContentPane().repaint();
					window.getContentPane().add(Obj.get(index));
					result.setText((Obj.get(index)).outputData());
				}
			}
		);
	}
}
