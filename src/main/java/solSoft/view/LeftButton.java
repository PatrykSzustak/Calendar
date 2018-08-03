package solSoft.view;

import solSoft.controller.Controller;
import solSoft.interfaces.DateChanged;

import javax.swing.*;
import java.util.Date;

public class LeftButton extends JButton implements DateChanged {

   public LeftButton(){
        setText("<");
        setBounds(130, 50, 70, 70);
//        setPreferredSize(new Dimension(70,70));
        Controller.getInstance().getDateChangedComponents().add(this);
    }

    @Override
    public void onDateChanged(Date date) {

    }
}
