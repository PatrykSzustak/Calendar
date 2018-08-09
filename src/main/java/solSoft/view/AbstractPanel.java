package solSoft.view;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractPanel extends JPanel {

    public AbstractPanel(){
        setBounds(0, 150, 1000, 550);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout());
    }

}
