package solSoft.view;

import solSoft.interfaces.DateChanged;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Button extends JButton implements DateChanged {


    public Button(int space){

        setBounds(space, 10, 100, 345);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }



    @Override
    public void onDateChanged(Date date) {

    }


}
