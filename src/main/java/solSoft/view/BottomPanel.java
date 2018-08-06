package solSoft.view;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BottomPanel extends JPanel  {



    public BottomPanel() {
        setBounds(0, 150, 1000, 550);
        setBackground(Color.LIGHT_GRAY);
    }

    public void create7Buttons(Date date) {
        removeAll();
        setLayout(new GridLayout(1, 7));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String string = dateFormat.format(date);
        int space = 0;
        for (int i = 0; i <= 6; i++) {
            space += 110;
            Button button = new Button(space);
            button.setText(string);
            add(button);
        }
        revalidate();
    }

    public void create35Buttons(Date date) {
        removeAll();
        setLayout(new GridLayout(5, 7));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String string = dateFormat.format(date);
        int spaceFromTop = 0;
        for (int i = 0; i <= 4; i++) {
            spaceFromTop += 70;
            int spaceNextTo = 0;
            for (int j = 0; j <= 6; j++) {
                spaceNextTo += 110;
                Button button = new Button(spaceNextTo, spaceFromTop);
                button.setText(string);
                add(button);
            }
        }
        revalidate();
    }



}
