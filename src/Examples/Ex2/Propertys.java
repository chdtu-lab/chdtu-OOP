package Examples.Ex2;

import javax.swing.*;
import java.awt.event.ItemListener;

public interface Propertys extends ItemListener{
    public void style(JCheckBox c);
    public void size(JRadioButton b);
    public void color(JComboBox box);
}
