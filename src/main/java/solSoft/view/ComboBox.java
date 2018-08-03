package solSoft.view;

import solSoft.controller.Controller;
import solSoft.interfaces.ViewChanged;

import javax.swing.*;

public class ComboBox extends JComboBox implements ViewChanged {

   public ComboBox() {

        addItem(View.WEEK);
        addItem(View.MONTH);
        setBounds(500, 50, 100, 70);
        Controller.getInstance().getViewChangedComponents().add(this);
    }



    @Override
    public void onViewChanged(View view) {

    }
}
