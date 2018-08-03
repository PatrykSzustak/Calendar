package solSoft.view;


import solSoft.controller.Controller;
import solSoft.interfaces.DateChanged;

import javax.swing.*;
import java.util.Date;

public class RightButton extends JButton implements DateChanged {

   public RightButton(){
        setText(">");
        setBounds(400, 50, 70, 70);
        Controller.getInstance().getDateChangedComponents().add(this);
    }

    @Override
    public void onDateChanged(Date date) {

    }
}
