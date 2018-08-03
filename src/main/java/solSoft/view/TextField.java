package solSoft.view;

import solSoft.controller.Controller;
import solSoft.interfaces.DateChanged;

import javax.swing.*;
import java.util.Date;

public class TextField extends JTextField implements DateChanged {

   public TextField(){
        setBounds(200, 50, 201, 70);
        Controller.getInstance().getDateChangedComponents().add(this);
    }

    @Override
    public void onDateChanged(Date date) {

    }
}
