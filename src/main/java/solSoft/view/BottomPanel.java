package solSoft.view;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel  {




    public BottomPanel() {
        setLayout(null);
        setBounds(0,200,1000,400);
        setBackground(Color.LIGHT_GRAY);
    }

    public void create7Fields(){
        int space = 0;
        for (int i = 0; i <= 6 ; i++) {
            space += 110;
            Button button = new Button(space);
            add(button);
        }
    }


}
