package solSoft.view.components;

import solSoft.controller.Controller;
import solSoft.controller.ViewMode;
import solSoft.view.interfaces.ChangeView;

import javax.swing.*;
import java.util.List;

public class ViewModeComboBox extends JComboBox<ViewMode> implements ChangeView {


    public ViewModeComboBox(List<ViewMode> list) {

        setBounds(500, 50, 100, 70);
        Controller.getInstance().registerViewChange(this);

        for (ViewMode viewMode : list) {
            addItem(viewMode);
        }

        addActionListener(e -> {
            ViewMode selectedViewMode = (ViewMode) getSelectedItem();
            Controller.getInstance().changeView(selectedViewMode);
        });
    }


    @Override
    public void onViewChange(ViewMode viewMode) {
    }
}
