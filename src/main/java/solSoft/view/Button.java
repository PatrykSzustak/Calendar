package solSoft.view;

import solSoft.controller.Controller;
import solSoft.interfaces.DateChanged;
import javax.swing.*;
import java.awt.*;
import java.util.Date;


public class Button extends JButton implements DateChanged {


    public Button(int space){

        setBounds(space, 10, 100, 345);
        setBorder(BorderFactory.createLineBorder(Color.black));
        Controller.getInstance().getDateChangedComponents().add(this);
    }
    public Button(int space,int topSpace){

        setBounds(space, topSpace, 100, 60);
        setBorder(BorderFactory.createLineBorder(Color.black));
        Controller.getInstance().getDateChangedComponents().add(this);
    }





    @Override
    public void onDateChanged(Date date) {

    }


}
